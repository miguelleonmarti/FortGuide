package es.ulpgc.miguel.fortguide.place_detail;

import java.lang.ref.WeakReference;

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
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    PlaceDetailState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }

    // update the view
    view.get().displayData(viewModel);

  }


}
