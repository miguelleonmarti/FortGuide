package es.ulpgc.miguel.fortguide.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "challenge")
public class ChallengeItem {

  @PrimaryKey
  private int id;
  private String content, details;
  private int weekId;

  public ChallengeItem(int id,String content,String details, int weekId){
    this.id = id;
    this.content = content;
    this.details = details;
    this.weekId = weekId;
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

  public int getWeekId() {
    return weekId;
  }

  public void setWeekId(int weekId) {
    this.weekId = weekId;
  }
}
