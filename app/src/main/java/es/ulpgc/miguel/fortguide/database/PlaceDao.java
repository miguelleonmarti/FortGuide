package es.ulpgc.miguel.fortguide.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.PlaceItem;

@Dao
public interface PlaceDao {

  @Insert
  void insertPlace(PlaceItem placeItem);

  @Update
  void updatePlace(PlaceItem placeItem);

  @Delete
  void deletePlace(PlaceItem placeItem);

  @Query("SELECT * FROM place")
  List<PlaceItem> loadPlace();
}
