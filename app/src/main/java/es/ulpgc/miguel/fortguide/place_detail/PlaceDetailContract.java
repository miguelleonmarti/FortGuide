package es.ulpgc.miguel.fortguide.place_detail;

import java.lang.ref.WeakReference;

interface PlaceDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(PlaceDetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(PlaceDetailState state);

    PlaceDetailState getDataFromPreviousScreen();
  }
}
