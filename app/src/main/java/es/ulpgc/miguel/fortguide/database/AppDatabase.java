package es.ulpgc.miguel.fortguide.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.data.ShopItem;
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.data.TheoryItem;
import es.ulpgc.miguel.fortguide.data.WeaponItem;

@Database(entities = {AdviceItem.class, PlaceItem.class, ShopItem.class, SupportItem.class,
    WeaponItem.class, TheoryItem.class}, version = 14, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

  public abstract AdviceDao adviceDao();

  //public abstract ChallengeDao challengeDao();

  //public abstract ChallengesWeeksDao challengesWeeksDao();

  public abstract PlaceDao placeDao();

  public abstract ShopDao shopDao();

  public abstract SupportDao supportDao();

  public abstract TheoryDao theoryDao();

  public abstract WeaponDao weaponDao();
}

