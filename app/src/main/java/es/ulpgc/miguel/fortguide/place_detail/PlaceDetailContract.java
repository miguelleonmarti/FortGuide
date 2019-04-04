package es.ulpgc.miguel.fortguide.place_detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.PlaceDetailItem;

interface PlaceDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayPlaceDetailData(PlaceDetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void fetchPlaceDetailData();
  }

  interface Model {
   // String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(PlaceDetailState state);

    PlaceDetailItem getDataFromPlaceScreen();
  }
}
