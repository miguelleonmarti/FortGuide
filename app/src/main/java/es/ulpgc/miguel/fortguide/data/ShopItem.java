package es.ulpgc.miguel.fortguide.data;


public class ShopItem extends Item{

  private final String image;

  public ShopItem(int id, String image, String content, String details) {
    super(id, content, details);
    this.image = image;
  }

  @Override
  public int getId() {
    return super.getId();
  }

  @Override
  public String getContent() {
    return super.getContent();
  }

  @Override
  public String getDetails() {
    return super.getDetails();
  }

  public String getImage() {
    return image;
  }
}
