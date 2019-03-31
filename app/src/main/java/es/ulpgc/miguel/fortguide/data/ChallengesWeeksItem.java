package es.ulpgc.miguel.fortguide.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ChallengesWeeksItem extends  ChallengeAbstract {

 public final List<ChallengesWeeksItem> items;

public ChallengesWeeksItem(int id,String content){
  super(id,content);
  items = new ArrayList<>();
}


  @Override
  public String toString() {
    return super.toString();
  }
}

