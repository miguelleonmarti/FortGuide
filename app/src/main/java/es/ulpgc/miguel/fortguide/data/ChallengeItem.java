package es.ulpgc.miguel.fortguide.data;

public class ChallengeItem {

  public int id;

  public String content;
  public String details;

  public int challengeWeeksId;

  public ChallengeItem(int id, String content, String details, int challengeWeeksId) {
    this.id = id;
    this.content = content;
    this.details = details;
    this.challengeWeeksId = challengeWeeksId;
  }

  @Override
  public String toString() {
    return content;
  }
}
