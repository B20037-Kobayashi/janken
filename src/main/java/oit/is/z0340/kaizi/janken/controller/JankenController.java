package oit.is.z0340.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0340.kaizi.janken.model.*;

/*
@ControllerをつけているからHTTPリクエストがあったら，このクラスがよばれる
*/

@Controller
public class JankenController {
  /**
   * jankenというGETリクエストがあったら janken()を呼び出し，janken.htmlを返す
   */

  @GetMapping("/janken")
  public String janken() {
    return "janken.html";
  }

  @PostMapping("/janken")
  public String formJanken(@RequestParam String userName, ModelMap model) {
    model.addAttribute("userName", userName);
    return "janken.html";
  }

  @GetMapping("/janken/{hand}")
  public String janken(@PathVariable Integer hand, ModelMap model) {
    Janken judge = new Janken(hand);
    model.addAttribute("judge", judge);
    return "janken.html";
  }
}
