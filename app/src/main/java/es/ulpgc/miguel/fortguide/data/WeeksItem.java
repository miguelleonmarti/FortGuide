package es.ulpgc.miguel.fortguide.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeeksItem {

  public int id;

  public String content;
  public String details;

  @SerializedName("challenges")
 public  List<WeeksItem> items;

  @Override
  public String toString() {
    return content;
  }
}

