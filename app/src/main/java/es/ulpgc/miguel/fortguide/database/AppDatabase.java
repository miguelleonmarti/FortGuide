package es.ulpgc.miguel.fortguide.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.data.ShopItem;
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.data.TheoryItem;
import es.ulpgc.miguel.fortguide.data.WeaponItem;

@Database(entities = {AdviceItem.class, PlaceItem.class, ShopItem.class, SupportItem.class,
    WeaponItem.class, TheoryItem.class, ChallengeItem.class, ChallengesWeeksItem.class}, version = 26, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

  /**
   * Abstract access to the app's database
   * DAO (Data Access Object)
   * @return AdviceDao
   */
  public abstract AdviceDao adviceDao();

  /**
   * Abstract access to the app's database
   * DAO (Data Access Object)
   * @return ChallengeDao
   */
  public abstract ChallengeDao challengeDao();

  /**
   * Abstract access to the app's database
   * DAO (Data Access Object)
   * @return ChallengesWeeksDao
   */
  public abstract ChallengesWeeksDao weekDao();

  /**
   * Abstract access to the app's database
   * DAO (Data Access Object)
   * @return PlaceDao
   */
  public abstract PlaceDao placeDao();

  /**
   * Abstract access to the app's database
   * DAO (Data Access Object)
   * @return ShopDao
   */
  public abstract ShopDao shopDao();

  /**
   * Abstract access to the app's database
   * DAO (Data Access Object)
   * @return SupportDao
   */
  public abstract SupportDao supportDao();

  /**
   * Abstract access to the app's database
   * DAO (Data Access Object)
   * @return TheoryDao
   */
  public abstract TheoryDao theoryDao();

  /**
   * Abstract access to the app's database
   * DAO (Data Access Object)
   * @return WeaponDao
   */
  public abstract WeaponDao weaponDao();
}

