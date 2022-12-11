package oit.is.z0340.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z0340.kaizi.janken.model.User;
import oit.is.z0340.kaizi.janken.model.UserMapper;
import oit.is.z0340.kaizi.janken.model.Match;
import oit.is.z0340.kaizi.janken.model.MatchMapper;
import oit.is.z0340.kaizi.janken.model.MatchInfo;
import oit.is.z0340.kaizi.janken.model.MatchInfoMapper;
import oit.is.z0340.kaizi.janken.model.Janken;
import oit.is.z0340.kaizi.janken.model.Room;

@Controller
public class JankenController {

  @Autowired
  UserMapper userMapper;
  @Autowired
  MatchMapper matchMapper;
  @Autowired
  MatchInfoMapper MatchInfoMapper;
  @Autowired
  public Room room;

  @GetMapping("/janken")
  public String janken(Principal prin, ModelMap model) {
    // roomの作成
    String loginUser = prin.getName();
    model.addAttribute("loginUser", loginUser);
    //
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    // user一覧の作成
    ArrayList<User> users1 = userMapper.selectAllUserName();
    model.addAttribute("users1", users1);
    // 試合結果一覧の作成
    ArrayList<Match> matchResults = matchMapper.selectAllMatch();
    model.addAttribute("matchResults", matchResults);

    ArrayList<MatchInfo> activeMatches = MatchInfoMapper.selectActiveMatch();
    model.addAttribute("activeMatches", activeMatches);

    return "janken.html";
  }

  @GetMapping("/match")
  public String match(Principal prin, @RequestParam Integer id, ModelMap model) {
    String loginUser = prin.getName();
    model.addAttribute("loginUser", loginUser);

    User selectedUser = userMapper.selectById(id);
    model.addAttribute("selectedUser", selectedUser);
    return "match.html";
  }

  @GetMapping("/janken/botbattle/{UHNum}")
  public String janken(Principal prin, @PathVariable Integer UHNum, ModelMap model) {
    String loginUser = prin.getName();
    model.addAttribute("loginUser", loginUser);

    Janken judge = new Janken(UHNum);
    judge.BotBattle();
    model.addAttribute("judge", judge);
    return "match.html";
  }

  // lec04
  // @GetMapping("/janken/fight")
  // public String janken(Principal prin, @RequestParam Integer id, @RequestParam
  // Integer hand, ModelMap model) {
  // String loginUser = prin.getName();
  // model.addAttribute("loginUser", loginUser);

  // User selectedUser = userMapper.selectById(id);
  // model.addAttribute("selectedUser", selectedUser);

  // Janken judge = new Janken(hand);
  // judge.BotBattle();
  // model.addAttribute("judge", judge);

  // Match matchResult = new Match();
  // User player = userMapper.getIdByName(loginUser);

  // matchResult.setUser1(2);
  // matchResult.setUser2(id);
  // matchResult.setUser1Hand(judge.getOppHand());
  // matchResult.setUser2Hand(judge.getUserHand());
  // matchMapper.insertMatchResult(matchResult);

  // return "match.html";
  // }

  // @GetMapping("/janken/fight")
  // public String janken(Principal prin, @RequestParam Integer id, @RequestParam
  // Integer hand, ModelMap model) {
  // String loginUser = prin.getName();
  // model.addAttribute("loginUser", loginUser);

  // User selectedUser = userMapper.selectById(id);
  // model.addAttribute("selectedUser", selectedUser);

  // Janken judge = new Janken(hand);
  // judge.BotBattle();
  // model.addAttribute("judge", judge);

  // User u = userMapper.getIdByName(loginUser);
  // int un = u.getId();

  // MatchInfo minfo = new MatchInfo(un, id, judge.getOppHand(), true);
  // MatchInfoMapper.insertMatchInfo(minfo);
  // return "wait.html";
  // }

  @GetMapping("/janken/fight")
  public String janken(Principal prin, @RequestParam Integer id, @RequestParam String hand, ModelMap model) {
    String loginUser = prin.getName();
    model.addAttribute("loginUser", loginUser);

    User u = userMapper.getIdByName(loginUser);
    int un = u.getId();

    if (MatchInfoMapper.selfCheckActive(un) == null) {
      MatchInfo addMatchInfo = new MatchInfo(un, id, hand, true);
      MatchInfoMapper.insertMatchInfo(addMatchInfo);
    } else {
      MatchInfo matchInfo = MatchInfoMapper.selfCheckActive(un);
      System.out.println(matchInfo.getUser1Hand());
      Match m = new Match(matchInfo.getUser2(), matchInfo.getUser1(), hand, matchInfo.getUser1Hand(), true);
      // 引数 自分のid，相手のid，自分の手，相手の手，isActive
      matchMapper.insertMatch(m);

    }
    return "wait.html";
  }

  @GetMapping("/janekn/informResult")
  public SseEmitter informResult() {
    final SseEmitter sseEmitter = new SseEmitter();
    System.out.println("here");
    return sseEmitter;
  }
}
