package es.ulpgc.miguel.fortguide.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;

@Dao
public interface ChallengesWeeksDao {

  @Insert
  void insertWeek(ChallengesWeeksItem weekItem);

  @Update
  void updateWeek(ChallengesWeeksItem weekItem);

  @Delete
  void deleteWeek(ChallengesWeeksItem weekItem);

  @Query("SELECT * FROM weeks")
  List<ChallengesWeeksItem> loadWeeks();
}
