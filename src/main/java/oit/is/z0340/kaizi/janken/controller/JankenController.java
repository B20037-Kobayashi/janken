package oit.is.z0340.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
