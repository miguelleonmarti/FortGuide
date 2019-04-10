package es.ulpgc.miguel.fortguide.data;

public class TheoryItem extends Item {

  private String user;
  private String likes;
  private String dislikes;

  public TheoryItem(int id,String user, String content, String details, String likes, String dislikes){
    super(id,content,details);
    this.user = user;
    this.likes = likes;
    this.dislikes = dislikes;
  }

  public String getUser() {
    return user;
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

  public void setLikes(String likes) {
    this.likes = likes;
  }

  public void setDislikes(String dislikes) {
    this.dislikes = dislikes;
  }
}
