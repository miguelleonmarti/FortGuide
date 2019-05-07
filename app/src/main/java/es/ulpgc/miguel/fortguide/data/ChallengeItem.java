package es.ulpgc.miguel.fortguide.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//@Entity(tableName = "challenge")
public class ChallengeItem {

  private int id;

  private String content;
  private String details;

  public int weeksId;

  public ChallengeItem(int id,String content,String details){
    this.id = id;
    this.content = content;
    this.details = details;
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
}
