package es.ulpgc.miguel.fortguide.data;

public class ChallengeItem {

  public int id;

  public String content;
  public String details;

  public int challengeWeeksId;


  @Override
  public String toString() {
    return content;
  }
}
