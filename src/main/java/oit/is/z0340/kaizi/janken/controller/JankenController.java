package oit.is.z0340.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0340.kaizi.janken.model.*;

@Controller
@RequestMapping("/janken")
public class JankenController {

  @Autowired
  public Room room;

  @GetMapping("entry")
  public String janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    return "janken.html";
  }

  @GetMapping("botbattle/{UHNum}")
  public String janken(@PathVariable Integer UHNum, ModelMap model) {
    Janken judge = new Janken(UHNum);
    judge.BotBattle();
    model.addAttribute("judge", judge);
    return "janken.html";
  }
}
