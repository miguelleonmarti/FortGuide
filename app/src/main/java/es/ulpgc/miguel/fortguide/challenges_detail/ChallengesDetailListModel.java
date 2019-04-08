package es.ulpgc.miguel.fortguide.challenges_detail;

import android.util.Log;

import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengesDetailListModel implements ChallengesDetailListContract.Model {

  public static String TAG = ChallengesDetailListModel.class.getSimpleName();

  private RepositoryContract repository;

  public ChallengesDetailListModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public void fetchChallengesDetailData(
      ChallengesWeeksItem challengesWeeksItem, RepositoryContract.GetChallengeDetailListCallback callback) {

    Log.e(TAG, "fetchChallengesDetailData()");
    repository.getChallengeDetailList(challengesWeeksItem, callback);
  }
}
