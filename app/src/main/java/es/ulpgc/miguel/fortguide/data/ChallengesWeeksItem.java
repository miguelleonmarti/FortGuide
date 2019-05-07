package es.ulpgc.miguel.fortguide.data;

import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChallengesWeeksItem {

  private int id;

  private String content;
  private String details;

  @SerializedName("detail")
  private List<ChallengeItem> items;

  public ChallengesWeeksItem(int id, String content, String details, List<ChallengeItem> items) {
    this.id = id;
    this.content = content;
    this.details = details;
    this.items = items;
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

  public List<ChallengeItem> getItems() {
    return items;
  }

  public void setItems(List<ChallengeItem> items) {
    this.items = items;
  }
}

