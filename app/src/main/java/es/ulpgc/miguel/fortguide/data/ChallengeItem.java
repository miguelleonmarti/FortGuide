package es.ulpgc.miguel.fortguide.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//@Entity(tableName = "challenge")
public class ChallengeItem {

  public int id;

  public String content;
  public String details;

  public int weeksId;

  @Override
  public String toString(){return  content;}
}
