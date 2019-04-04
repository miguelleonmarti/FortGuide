package es.ulpgc.miguel.fortguide.challenges_weeks;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class WeeksListModel implements WeeksListContract.Model {

  public static String TAG = WeeksListModel.class.getSimpleName();


  private RepositoryContract repository;

  public WeeksListModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
 public void fetchWeeksListData(final RepositoryContract.GetWeeksListCallback callback){
    Log.e(TAG, "fetchWeeksListData");
    repository.loadWeeks(new RepositoryContract.FetchWeeksDataCallback() {
      @Override
      public void onWeeksDataFetched(boolean error) {
        if(!error){
          repository.getWeeksList(callback);
        }
      }
    });
  }
}
