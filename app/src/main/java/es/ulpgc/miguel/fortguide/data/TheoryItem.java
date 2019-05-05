package es.ulpgc.miguel.fortguide.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "theory")
public class TheoryItem {

  @PrimaryKey(autoGenerate = true)
  private int id;

  private String content, details, user, likes, dislikes;

  public TheoryItem(int id, String content, String details, String user,String likes, String dislikes){
    this.id = id;
    this.content = content;
    this.details = details;
    this.user = user;
    this.likes = likes;
    this.dislikes = dislikes;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getLikes() {
    return likes;
  }

  public void setLikes(String likes) {
    this.likes = likes;
  }

  public String getDislikes() {
    return dislikes;
  }

  public void setDislikes(String dislikes) {
    this.dislikes = dislikes;
  }
}
