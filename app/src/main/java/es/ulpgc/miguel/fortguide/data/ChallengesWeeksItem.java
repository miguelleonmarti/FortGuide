package es.ulpgc.miguel.fortguide.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChallengesWeeksItem {

  public int id;

  public String content;
  public String details;

  @SerializedName("weeks")
 public  List<ChallengesWeeksItem> items;

  @Override
  public String toString() {
    return content;
  }
}

