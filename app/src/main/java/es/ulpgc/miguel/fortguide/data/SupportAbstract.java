package es.ulpgc.miguel.fortguide.data;

public abstract class SupportAbstract {
  public final int id;
  public final String content;

  public SupportAbstract(int id, String content) {
    this.id = id;
    this.content = content;
  }

  @Override
  public String toString() {
    return content;
  }
}
