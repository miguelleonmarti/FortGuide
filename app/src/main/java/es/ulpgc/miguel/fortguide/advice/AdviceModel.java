package es.ulpgc.miguel.fortguide.advice;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class AdviceModel implements AdviceContract.Model {

  public static String TAG = AdviceModel.class.getSimpleName();

  private RepositoryContract repository;
  private List<AdviceItem> adviceItems;

  public AdviceModel(RepositoryContract repository) {
    this.repository = repository;
    this.adviceItems = new ArrayList<>();
  }

  @Override
  public void fetchAdviceListData(final RepositoryContract.GetAdviceListCallback callback) {
    Log.e(TAG, "fetchAdviceListData()");

    repository.loadAdvice(new RepositoryContract.FetchAdviceDataCallback() {
      @Override
      public void onAdviceDataFetched(boolean error) {
      if(!error){
        repository.getAdviceList(callback);
      }
      }
    });
  }

}
