package es.ulpgc.miguel.fortguide.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.SupportItem;

@Dao
public interface SupportDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertSupport(SupportItem supportItem);

  @Update
  void updateSupport(SupportItem supportItem);

  @Delete
  void deleteSupport(SupportItem supportItem);

  @Query("SELECT * FROM support")
  List<SupportItem> loadSupport();
}
