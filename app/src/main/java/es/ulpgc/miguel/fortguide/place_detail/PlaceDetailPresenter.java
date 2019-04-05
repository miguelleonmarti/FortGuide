package es.ulpgc.miguel.fortguide.place_detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.PlaceDetailItem;
import es.ulpgc.miguel.fortguide.data.PlaceItem;

public class PlaceDetailPresenter implements PlaceDetailContract.Presenter {

  public static String TAG = PlaceDetailPresenter.class.getSimpleName();

  private WeakReference<PlaceDetailContract.View> view;
  private PlaceDetailViewModel viewModel;
  private PlaceDetailContract.Model model;
  private PlaceDetailContract.Router router;

  public PlaceDetailPresenter(PlaceDetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<PlaceDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(PlaceDetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(PlaceDetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }

  @Override
  public void fetchPlaceDetailData() {
    // Log.e(TAG, "fetchPlaceDetailData()");

    // set passed state
    PlaceItem placeItem = router.getDataFromPlaceScreen();
    if( placeItem != null){
      viewModel.placeItem = placeItem;
    }
view.get().displayPlaceDetailData(viewModel);
  }


}
