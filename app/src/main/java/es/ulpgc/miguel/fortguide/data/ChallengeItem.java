package es.ulpgc.miguel.fortguide.data;

public class ChallengeItem  {

  public int id;

  public String content;
  public String details;

  public int weeksId;

public ChallengeItem(int id,String content,String details,int weeksId){
  this.id = id;
  this.content = content;
  this.details = details;
  this.weeksId = weeksId;
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

  public int getWeeksId() {
    return weeksId;
  }

  public void setWeeksId(int weeksId) {
    this.weeksId = weeksId;
  }

  @Override
  public String toString() {
    return content;
  }
}
