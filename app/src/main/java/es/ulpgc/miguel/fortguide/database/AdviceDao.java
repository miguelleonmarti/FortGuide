package es.ulpgc.miguel.fortguide.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.AdviceItem;

@Dao
public interface AdviceDao {

  @Insert
  void insertAdvice(AdviceItem adviceItem);

  @Update
  void updateAdvice(AdviceItem adviceItem);

  @Delete
  void deleteAdvice(AdviceItem adviceItem);

  @Query("SELECT * FROM advice")
  List<AdviceItem> loadAdvice();
}
