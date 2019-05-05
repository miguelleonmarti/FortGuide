package es.ulpgc.miguel.fortguide.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.WeaponItem;

@Dao
public interface WeaponDao {

  @Insert
  void insertWeapon(WeaponItem weaponItem);

  @Update
  void updateWeapon(WeaponItem weaponItem);

  @Delete
  void deleteWeapon(WeaponItem weaponItem);

  @Query("SELECT * FROM weapon")
  List<WeaponItem> loadWeapon();

  @Query("SELECT * FROM weapon WHERE rarity =:rarity")
  List<WeaponItem> loadWeaponRarity(String rarity);

}
