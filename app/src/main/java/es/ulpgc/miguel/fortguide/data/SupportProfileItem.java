package es.ulpgc.miguel.fortguide.data;

public class SupportProfileItem {
  public final String details, content;
  public int id;

  public SupportProfileItem(int id, String content, String details) {
    this.details = details;
    this.content = content;
    this.id = id;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
