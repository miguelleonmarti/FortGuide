package es.ulpgc.miguel.fortguide.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "shop")
public class ShopItem {

  @PrimaryKey
  private final int id;

  private final String content, details, image;

  public ShopItem(int id, String image, String content, String details) {
    this.id = id;
    this.content = content;
    this.details = details;
    this.image = image;
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
}
