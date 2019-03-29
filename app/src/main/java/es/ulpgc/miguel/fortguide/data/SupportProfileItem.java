package es.ulpgc.miguel.fortguide.data;

public class SupportProfileItem extends SupportAbstract {
  public final String details;

  public SupportProfileItem(int id, String content, String details) {
    super(id, content);
    this.details = details;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
