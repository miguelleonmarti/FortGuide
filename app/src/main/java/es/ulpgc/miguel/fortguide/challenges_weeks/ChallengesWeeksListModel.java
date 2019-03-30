package es.ulpgc.miguel.fortguide.challenges_weeks;

import android.util.Log;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengesWeeksListModel implements ChallengesWeeksListContract.Model {

  public static String TAG = ChallengesWeeksListModel.class.getSimpleName();

  private RepositoryContract repository;

  public ChallengesWeeksListModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public List<ChallengesWeeksItem> fetchChallengeListData() {
    Log.e(TAG, "fetchChallengeListData()");
      return repository.getChallengeList();
  }
}
