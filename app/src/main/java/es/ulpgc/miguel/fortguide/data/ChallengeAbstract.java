package es.ulpgc.miguel.fortguide.data;

public abstract class ChallengeAbstract {
  public final int id;
  public final String content;

  public ChallengeAbstract(int id, String content){
    this.id = id;
    this.content = content;
  }

  @Override
  public String toString(){
    return content;
  }
}
