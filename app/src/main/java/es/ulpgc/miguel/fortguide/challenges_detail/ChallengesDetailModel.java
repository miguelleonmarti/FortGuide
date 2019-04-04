package es.ulpgc.miguel.fortguide.challenges_detail;

import android.util.Log;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengesDetailModel implements ChallengesDetailContract.Model {

  public static String TAG = ChallengesDetailModel.class.getSimpleName();

  private RepositoryContract repository;

  public ChallengesDetailModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public void fetchChallengesDetailData(
      ChallengesWeeksItem challengesWeeksItem, RepositoryContract.GetChallengeDetailListCallback callback) {

    Log.e(TAG, "fetchChallengesDetailData()");
    repository.getChallengeDetailList(challengesWeeksItem, callback);
  }
}
