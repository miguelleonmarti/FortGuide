package es.ulpgc.miguel.fortguide.place;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.PlaceItem;

interface PlaceContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(PlaceViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void startMenuScreen();

    void selectPlaceListData(PlaceItem placeItem);

    //void selectPlaceListData(PlaceItem placeItem);
  }

  interface Model {
    List<PlaceItem> fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(PlaceItem placeItem);

    PlaceState getDataFromPreviousScreen();

    void navigateToMenuScreen();
  }
}
