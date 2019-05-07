package es.ulpgc.miguel.fortguide.data;

import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChallengesWeeksItem {

  public int id;

  public String content;
  public String details;

  @SerializedName("detail")
  public List<ChallengeItem> items;

  @Override
  public String toString(){return content;}
}

