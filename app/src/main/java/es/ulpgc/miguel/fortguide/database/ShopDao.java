package es.ulpgc.miguel.fortguide.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.ShopItem;

@Dao
public interface ShopDao {

  @Insert
  void insertShop(ShopItem shopItem);

  @Update
  void updateShop(ShopItem shopItem);

  @Delete
  void deleteShop(ShopItem shopItem);

  @Query("SELECT * FROM shop")
  List<ShopItem> loadShop();

  @Query("DELETE FROM shop")
  void deleteAllShop();
}
