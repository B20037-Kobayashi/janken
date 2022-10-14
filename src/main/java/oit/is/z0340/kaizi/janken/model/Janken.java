package oit.is.z0340.kaizi.janken.model;

public class Janken {
  Integer UHNum;
  Integer UHNum1;
  Integer UHNum2;
  Integer BHNum;
  Integer resultNum = -1;
  String userHand;
  String oppHand;
  String result;

  public Janken(Integer UHNum) {
    this.UHNum = UHNum;
    this.BHNum = (int) (Math.random() * 10) % 3 + 1;
  }

  public Janken(Integer UHNum1, Integer UHNum2) {
    this.UHNum1 = UHNum1;
    this.UHNum2 = UHNum2;
  }

  public void UsersBattle() {
    setUserHand(this.UHNum1);
    setUserHand(this.UHNum2);
    setBattleResult(this.UHNum1, this.UHNum2);
  }

  public void BotBattle() {
    setUserHand(this.UHNum);
    setOppHand(this.BHNum);
    setBattleResult(this.UHNum, this.BHNum);
  }

  public void setUserHand(Integer UHNum) {
    switch (UHNum) {
      case 1:
        this.userHand = "グー";
        break;
      case 2:
        this.userHand = "チョキ";
        break;
      case 3:
        this.userHand = "パー";
        break;
    }
  }

  public void setOppHand(Integer OHNum) {
    switch (OHNum) {
      case 1:
        this.oppHand = "グー";
        break;
      case 2:
        this.oppHand = "チョキ";
        break;
      case 3:
        this.oppHand = "パー";
        break;
    }
  }

  public void setBattleResult(Integer UHNum, Integer oppNum) {
    switch (UHNum) {
      case 1:
        switch (oppNum) {
          case 1:
            this.resultNum = 0;// あいこ
            break;
          case 2:
            this.resultNum = 1;// 勝ち
            break;
          case 3:
            this.resultNum = 2;// 負け
            break;
        }
        break;
      case 2:
        switch (oppNum) {
          case 1:
            this.resultNum = 2;
            break;
          case 2:
            this.resultNum = 0;
            break;
          case 3:
            this.resultNum = 1;
            break;
        }
        break;
      case 3:
        switch (oppNum) {
          case 1:
            this.resultNum = 1;
            break;
          case 2:
            this.resultNum = 2;
            break;
          case 3:
            this.resultNum = 0;
            break;
        }
        break;
    }
    switch (this.resultNum) {
      case 0:
        this.result = "Drow";
        break;
      case 1:
        this.result = "You Win!";
        break;
      case 2:
        this.result = "You Lose...";
        break;
    }
  }

  public Integer getUHNum() {
    return UHNum;
  }

  public void setUHNum(Integer UHNum) {
    this.UHNum = UHNum;
  }

  public String getUserHand() {
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

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

}
