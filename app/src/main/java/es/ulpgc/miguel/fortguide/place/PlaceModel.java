package es.ulpgc.miguel.fortguide.place;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class PlaceModel implements PlaceContract.Model {

  public static String TAG = PlaceModel.class.getSimpleName();

  private List<PlaceItem> placeItems;
  private RepositoryContract repository;

  public PlaceModel(RepositoryContract repository) {
    this.repository = repository;
    this.placeItems = new ArrayList<>();
  }

  @Override
  public void fetchPlaceListData(final RepositoryContract.GetPlaceListCallback callback) {
    Log.e(TAG, "fetchPlaceListData()");

    repository.loadPlace(new RepositoryContract.FetchPlaceDataCallback() {
      @Override
      public void onPlaceDataFetched(boolean error) {
        if (!error) {
          repository.getPlaceList(callback);
        }
      }
    });

  }
}
