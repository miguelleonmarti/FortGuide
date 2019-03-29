package es.ulpgc.miguel.fortguide.data;

public class ChallengeItem extends ChallengeAbstract {

  public final String details;

  public ChallengeItem(int id, String content, String details) {
    super(id, content);
    this.details = details;
  }

    @Override
    public String toString() {
      return super.toString();
    }
}
