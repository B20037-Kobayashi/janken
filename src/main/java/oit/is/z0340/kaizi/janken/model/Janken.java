package oit.is.z0340.kaizi.janken.model;

public class Janken {
  Integer hand;
  String result;
  String userHand;
  String oppHand;

  public Janken(Integer hand) {
    this.hand = hand;
    
    oppHand = "チョキ";
    switch (hand) {
      case 1:
        userHand = "グー";
        result = "You Win!";// グー
        break;
      case 2:
        userHand = "グー";
        result = "Drow";// チョキ
        break;
      case 3:
        userHand = "グー";
        result = "You Lose...";// パー
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
