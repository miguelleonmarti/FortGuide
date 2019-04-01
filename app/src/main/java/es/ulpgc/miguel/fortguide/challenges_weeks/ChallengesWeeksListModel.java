package es.ulpgc.miguel.fortguide.challenges_weeks;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengesWeeksListModel implements ChallengesWeeksListContract.Model {

  public static String TAG = ChallengesWeeksListModel.class.getSimpleName();

  private List<ChallengesWeeksItem> challengesWeeksItems;

  private RepositoryContract repository;

  public ChallengesWeeksListModel(RepositoryContract repository) {
    this.challengesWeeksItems  = new ArrayList<>();
    this.repository = repository;
  }

  @Override
 public void fetchChallengesWeeksListData(final RepositoryContract.GetChallengesWeeksListCallback callback){
    Log.e(TAG, "fetchChallengesWeeksListData");
    repository.loadChallengeWeeks(new RepositoryContract.FetchChallengesWeeksDataCallback() {
      @Override
      public void onChallengeWeeksDataFetched(boolean error) {
        if(!error){
          repository.getChallengesWeeksList(callback);
        }
      }
    });
  }
}
