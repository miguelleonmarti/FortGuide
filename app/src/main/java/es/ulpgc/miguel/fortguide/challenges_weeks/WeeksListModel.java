package es.ulpgc.miguel.fortguide.challenges_weeks;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.WeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class WeeksListModel implements WeeksListContract.Model {

  public static String TAG = WeeksListModel.class.getSimpleName();

  private List<WeeksItem> weeksItems;

  private RepositoryContract repository;

  public WeeksListModel(RepositoryContract repository) {
    this.weeksItems = new ArrayList<>();
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
