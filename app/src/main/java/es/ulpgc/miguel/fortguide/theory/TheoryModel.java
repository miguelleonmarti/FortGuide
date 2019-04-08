package es.ulpgc.miguel.fortguide.theory;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.TheoryItem;

public class TheoryModel implements TheoryContract.Model {

  public static String TAG = TheoryModel.class.getSimpleName();

  private RepositoryContract repository;
  private List<TheoryItem> theoryItems;

  public TheoryModel(RepositoryContract repository) {
    this.repository = repository;
    this.theoryItems = new ArrayList<>();
  }


  @Override
  public void fetchTheoryListData(final RepositoryContract.GetTheoryListCallback callback) {
    Log.e(TAG, "fetchTheoryListData()");

    repository.loadTheory(new RepositoryContract.FetchTheoryDataCallback() {
      @Override
      public void onTheoryDataFetched(boolean error) {
        if(!error){
          repository.getTheoryList(callback);
        }
      }
    });
  }
}
