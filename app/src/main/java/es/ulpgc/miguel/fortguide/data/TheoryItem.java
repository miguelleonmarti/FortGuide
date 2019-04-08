package es.ulpgc.miguel.fortguide.data;

public class TheoryItem {
  private int id;
  private String user;
  private String content;
  private String details;
  private String likes;
  private String dislikes;

  public TheoryItem(int id,String user, String content, String details, String likes, String dislikes){
    this.id = id;
    this.user = user;
    this.content = content;
    this.details = details;
    this.likes = likes;
    this.dislikes = dislikes;
  }

  public int getId() {
    return id;
  }

  public String getUser() {
    return user;
  }

  public String getContent() {
    return content;
  }

  public String getDetails() {
    return details;
  }

  public String getLikes() {
    return likes;
  }

  public String getDislikes() {
    return dislikes;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public void setLikes(String likes) {
    this.likes = likes;
  }

  public void setDislikes(String dislikes) {
    this.dislikes = dislikes;
  }
}
