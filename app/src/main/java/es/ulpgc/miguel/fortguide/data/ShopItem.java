package es.ulpgc.miguel.fortguide.data;


public class ShopItem {

  private final String id;
  private final String content;
  private final String details;
  private final String image;


  public ShopItem(String id, String image, String content, String details) {
    this.id = id;
    this.content = content;
    this.details = details;
    this.image = image;
  }

  public String getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public String getDetails() {
    return details;
  }

  public String getImage() {
    return image;
  }
}
