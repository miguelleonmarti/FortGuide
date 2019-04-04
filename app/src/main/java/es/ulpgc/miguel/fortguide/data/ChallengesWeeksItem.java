package es.ulpgc.miguel.fortguide.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChallengesWeeksItem {

  public int id;

  public String content;
  public String details;

  @SerializedName("challenges")
 public  List<ChallengeItem> items;

  @Override
  public String toString() {
    return content;
  }
}

