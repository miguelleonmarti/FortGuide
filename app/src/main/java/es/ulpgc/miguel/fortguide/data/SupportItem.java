package es.ulpgc.miguel.fortguide.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "support")
public class SupportItem {

  @PrimaryKey
  private int id;

  private final String content, details, image, code, instagram, twitter, twitch, youtube;

  public SupportItem(int id, String image, String content, String details, String code, String instagram, String twitter, String twitch, String youtube) {
    this.id = id;
    this.content = content;
    this.details = details;
    this.image = image;
    this.code = code;
    this.instagram = instagram;
    this.twitter = twitter;
    this.twitch = twitch;
    this.youtube = youtube;
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

  public String getCode() {
    return code;
  }

  public String getInstagram() {
    return instagram;
  }

  public String getTwitter() {
    return twitter;
  }

  public String getTwitch() {
    return twitch;
  }

  public String getYoutube() {
    return youtube;
  }
}

