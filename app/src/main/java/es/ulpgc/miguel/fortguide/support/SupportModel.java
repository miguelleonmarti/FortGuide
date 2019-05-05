package es.ulpgc.miguel.fortguide.support;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.SupportItem;

public class SupportModel implements SupportContract.Model {

  public static String TAG = SupportModel.class.getSimpleName();

  private List<SupportItem> supportItems;
  private RepositoryContract repository;

  public SupportModel(RepositoryContract repository) {
    this.repository = repository;
    this.supportItems = new ArrayList<>();
  }

  @Override
  public void fetchSupportListData(final RepositoryContract.GetSupportListCallback callback) {
    Log.e(TAG, "fetchSupportListData()");

    repository.loadSupport(true, new RepositoryContract.FetchSupportDataCallback() {
      @Override
      public void onSupportDataFetched(boolean error) {
        if (!error) {
          repository.getSupportList(callback);
        }
      }
    });
  }
}
