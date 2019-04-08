package es.ulpgc.miguel.fortguide.data;

public class TheoryItem {
  private int id;
  private String user;
  private String content;
  private String details;
  private int likes;
  private int dislikes;

  public TheoryItem(int id,String user, String content, String details, int likes, int dislikes){
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

  public int getLikes() {
    return likes;
  }

  public int getDislikes() {
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

  public void setLikes(int likes) {
    this.likes = likes;
  }

  public void setDislikes(int dislikes) {
    this.dislikes = dislikes;
  }
}
