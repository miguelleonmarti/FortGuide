package es.ulpgc.miguel.fortguide.data;

public class PlaceItem extends Item {

  private final String image, chest, people;

  public PlaceItem(int id, String image, String content, String details, String chest, String people) {
    super(id, content, details);
    this.image = image;
    this.chest = chest;
    this.people = people;
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

  public String getChest() {
    return chest;
  }

  public String getPeople() {
    return people;
  }
}
