package es.ulpgc.miguel.fortguide.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "weeks")
public class ChallengesWeeksItem {

  @PrimaryKey
  private int id;
  private String content;

  public ChallengesWeeksItem(int id, String content) {
    this.id = id;
    this.content = content;
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
}

