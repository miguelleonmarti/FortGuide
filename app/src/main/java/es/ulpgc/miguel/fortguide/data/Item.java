package es.ulpgc.miguel.fortguide.data;

import android.arch.persistence.room.PrimaryKey;

public abstract class Item {

  @PrimaryKey
  private final int id;
  private final String content, details;

  public Item(int id, String content, String details) {
    this.id = id;
    this.content = content;
    this.details = details;
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
}
