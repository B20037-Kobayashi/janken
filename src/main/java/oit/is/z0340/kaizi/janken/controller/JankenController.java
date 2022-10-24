package oit.is.z0340.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0340.kaizi.janken.model.User;
import oit.is.z0340.kaizi.janken.model.UserMapper;
import oit.is.z0340.kaizi.janken.model.Match;
import oit.is.z0340.kaizi.janken.model.MatchMapper;
import oit.is.z0340.kaizi.janken.model.Janken;
import oit.is.z0340.kaizi.janken.model.Room;

@Controller
public class JankenController {

  @Autowired
  UserMapper userMapper;
  @Autowired
  MatchMapper matchMapper;
  @Autowired
  public Room room;

  @GetMapping("/janken")
  public String janken(Principal prin, ModelMap model) {
    // roomの作成
    String loginUser = prin.getName();
    model.addAttribute("loginUser", loginUser);
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    // user一覧の作成
    ArrayList<User> users1 = userMapper.selectAllUserName();
    model.addAttribute("users1", users1);
    // 試合結果一覧の作成
    ArrayList<Match> matchResults = matchMapper.selectAllMatch();
    model.addAttribute("matchResults", matchResults);
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
  public String janken(@PathVariable Integer UHNum, ModelMap model) {
    Janken judge = new Janken(UHNum);
    judge.BotBattle();
    model.addAttribute("judge", judge);
    return "janken.html";
  }
}
