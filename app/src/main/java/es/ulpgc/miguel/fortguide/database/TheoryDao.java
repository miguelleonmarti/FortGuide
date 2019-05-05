package es.ulpgc.miguel.fortguide.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.TheoryItem;

@Dao
public interface TheoryDao {

  @Insert
  void insertTheory(TheoryItem theoryItem);

  @Update
  void updateTheory(TheoryItem theoryItem);

  @Delete
  void deleteTheory(TheoryItem theoryItem);

  @Query("SELECT * FROM theory")
  List<TheoryItem> loadTheory();
}
