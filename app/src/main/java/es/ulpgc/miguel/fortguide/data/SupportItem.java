package es.ulpgc.miguel.fortguide.data;

public class SupportItem extends Item{

  private final String image, code, instagram, twitter, twitch, youtube;

  public SupportItem(int id, String image, String content, String details, String code, String instagram, String twitter, String twitch, String youtube) {
    super(id, content, details);
    this.image = image;
    this.code = code;
    this.instagram = instagram;
    this.twitter = twitter;
    this.twitch = twitch;
    this.youtube = youtube;
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

