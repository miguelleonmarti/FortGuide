package es.ulpgc.miguel.fortguide.place;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.PlaceItem;

public class PlacePresenter implements PlaceContract.Presenter {

  public static String TAG = PlacePresenter.class.getSimpleName();

  private WeakReference<PlaceContract.View> view;
  private PlaceViewModel viewModel;
  private PlaceContract.Model model;
  private PlaceContract.Router router;

  public PlacePresenter(PlaceState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<PlaceContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(PlaceContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(PlaceContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");
    List<PlaceItem> placeItemList = model.fetchData();
    viewModel.places = placeItemList;
    view.get().displayData(viewModel);
  }

  @Override
  public void selectPlaceListData(PlaceItem placeItem) {
    router.passDataToNextScreen(placeItem);
    router.navigateToPlaceDetailScreen();
  }

  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }

@Override
  public void starPlaceDetailScreen(){router.navigateToPlaceDetailScreen();}
}
