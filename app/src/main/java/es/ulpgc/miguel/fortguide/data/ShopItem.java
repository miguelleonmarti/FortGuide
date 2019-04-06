package es.ulpgc.miguel.fortguide.data;

public class ShopItem {
  private int id;
  private String image, content, details;

  public ShopItem(int id, String image, String content, String details) {
    this.id = id;
    this.image = image;
    this.content = content;
    this.details = details;
  }

  public int getId() {
    return id;
  }

  public String getImage() {
    return image;
  }

  public String getContent() {
    return content;
  }

  public String getDetails() {
    return details;
  }
}
