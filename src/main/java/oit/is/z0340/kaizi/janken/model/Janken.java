package oit.is.z0340.kaizi.janken.model;

import javax.swing.text.AbstractDocument.BranchElement;

public class Janken {
  Integer hand;
  String result;
  String userHand;
  String oppHand;

  public Janken(Integer hand) {
    this.hand = hand;
    Integer cpuHand = (int) (Math.random() * 10) % 3 + 1;
    int result_num = -1;

    switch (cpuHand) {
      case 1:
        oppHand = "グー";
        break;
      case 2:
        oppHand = "チョキ";
        break;
      case 3:
        oppHand = "パー";
        break;
    }
    switch (hand) {
      case 1:
        userHand = "グー";
        break;
      case 2:
        userHand = "チョキ";
        break;
      case 3:
        userHand = "パー";
        break;
    }

    switch (hand) {
      case 1:
        switch (cpuHand) {
          case 1:
            result_num = 0;// あいこ
            break;
          case 2:
            result_num = 1;// 勝ち
            break;
          case 3:
            result_num = 2;// 負け
            break;
        }
        break;
      case 2:
        switch (cpuHand) {
          case 1:
            result_num = 2;
            break;
          case 2:
            result_num = 0;
            break;
          case 3:
            result_num = 1;
            break;
        }
        break;
      case 3:
        switch (cpuHand) {
          case 1:
            result_num = 1;
            break;
          case 2:
            result_num = 2;
            break;
          case 3:
            result_num = 0;
            break;
        }
        break;
    }
    switch (result_num) {
      case 0:
        result = "Drow";
        break;
      case 1:
        result = "You Win!";
        break;
      case 2:
        result = "You Lose...";
        break;
    }
  }

  public Integer getHand() {
    return hand;
  }

  public void setHand(Integer hand) {
    this.hand = hand;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getuserHand() {
    return userHand;
  }

  public void setUserHand(String userHand) {
    this.userHand = userHand;
  }

  public String getOppHand() {
    return oppHand;
  }

  public void setOppHand(String oppHand) {
    this.oppHand = oppHand;
  }

}
