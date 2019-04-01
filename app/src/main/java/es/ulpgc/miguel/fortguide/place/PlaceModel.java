package es.ulpgc.miguel.fortguide.place;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.PlaceItem;

public class PlaceModel implements PlaceContract.Model {

  public static String TAG = PlaceModel.class.getSimpleName();

  private List<PlaceItem> placeItems = new ArrayList();


  public PlaceModel() {

  }

  @Override
  public List<PlaceItem> fetchData() {
    // Log.e(TAG, "fetchData()");
    placeItems.add(new PlaceItem(1, "","Lugar 1","","",""));
    placeItems.add(new PlaceItem(2, "","Lugar 2","","",""));
    placeItems.add(new PlaceItem(3, "","Lugar 3","","",""));
    placeItems.add(new PlaceItem(4, "","Lugar 4","","",""));
    placeItems.add(new PlaceItem(5, "","Lugar 5","","",""));
    placeItems.add(new PlaceItem(6, "","Lugar 6","","",""));
    return placeItems;
  }
}
