package es.ulpgc.miguel.fortguide.data;

public class PlaceItem {
  public final int id;
  public final String image, content, details, chest, people;

  public PlaceItem(int id, String image, String content, String details, String chest, String people) {
    this.id = id;
    this.image = image;
    this.content = content;
    this.details = details;
    this.chest = chest;
    this.people = people;
  }

  // getters

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

  public String getChest() {
    return chest;
  }

  public String getPeople() {
    return people;
  }
}
