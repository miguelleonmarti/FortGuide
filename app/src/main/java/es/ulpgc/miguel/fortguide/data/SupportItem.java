package es.ulpgc.miguel.fortguide.data;

public class SupportItem {

  public final int id, image;
  public final String content, details, code, instagram, twitter, twitch, youtube;

  public SupportItem(int id, int image, String content, String details, String code, String instagram, String twitter, String twitch, String youtube) {
    this.id = id;
    this.image = image;
    this.content = content;
    this.details = details;
    this.code = code;
    this.instagram = instagram;
    this.twitter = twitter;
    this.twitch = twitch;
    this.youtube = youtube;
  }

  public int getId() {
    return id;
  }

  public int getImage() {
    return image;
  }

  public String getContent() {
    return content;
  }

  public String getDetails() {
    return details;
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

