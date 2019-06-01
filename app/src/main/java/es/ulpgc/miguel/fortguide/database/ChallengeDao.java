package es.ulpgc.miguel.fortguide.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ShopItem;

@Dao
public interface ChallengeDao {
  @Insert
  void insertChallenge(ChallengeItem challengeItem);

  @Update
  void updateChallenge(ChallengeItem challengeItem);

  @Delete
  void deleteChallenge(ChallengeItem challengeItem);

  @Query("SELECT * FROM challenge WHERE weekId =:weekId")
  List<ChallengeItem> loadChallenges(int weekId);
}
