package es.ulpgc.miguel.fortguide.place_detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.PlaceDetailItem;
import es.ulpgc.miguel.fortguide.data.PlaceItem;

public interface PlaceDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayPlaceDetailData(PlaceDetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void fetchPlaceDetailData();
    void startMenuScreen();
  }

  interface Model {
   // String fetchData();
  }

  interface Router {
    void navigateToMenuScreen();

    void passDataToNextScreen(PlaceDetailState state);

    PlaceItem getDataFromPlaceScreen();
  }
}
