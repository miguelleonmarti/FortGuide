package es.ulpgc.miguel.fortguide.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "place")
public class PlaceItem {

  @PrimaryKey
  private final int id;

  private final String content, details, image, chest, people;

  public PlaceItem(int id, String image, String content, String details, String chest, String people) {
    this.id = id;
    this.content = content;
    this.details = details;
    this.image = image;
    this.chest = chest;
    this.people = people;
  }

  public int getId() {
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

  public String getChest() {
    return chest;
  }

  public String getPeople() {
    return people;
  }
}
