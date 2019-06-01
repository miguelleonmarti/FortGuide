package es.ulpgc.miguel.fortguide.challenges_weeks;

import android.util.Log;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengesWeeksListModel implements ChallengesWeeksListContract.Model {

  public static String TAG = ChallengesWeeksListModel.class.getSimpleName();

  private RepositoryContract repository;

  public ChallengesWeeksListModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
 public void fetchWeeksListData(final RepositoryContract.GetWeeksListCallback callback){
    //Log.e(TAG, "fetchWeeksListData");
    repository.loadWeeks(true, new RepositoryContract.FetchWeeksDataCallback() {
      @Override
      public void onWeeksDataFetched(boolean error) {
        if(!error){
          repository.getWeeksList(callback);
        }
      }
    });
  }
}
