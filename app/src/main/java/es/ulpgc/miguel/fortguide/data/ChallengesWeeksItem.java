package es.ulpgc.miguel.fortguide.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChallengesWeeksItem {

  public int id;

  public String content;
  public String details;

  public ChallengesWeeksItem(int id, String content, String details) {
    this.id = id;
    this.content = content;
    this.details = details;
  }


  @SerializedName("detail")
  public List<ChallengeItem> items;

  @Override
  public String toString() {
    return content;
  }
}

