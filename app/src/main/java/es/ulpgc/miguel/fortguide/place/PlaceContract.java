package es.ulpgc.miguel.fortguide.place;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public interface PlaceContract {

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

  }

  interface Model {
    void fetchPlaceListData(RepositoryContract.GetPlaceListCallback callback);
  }

  interface Router {
    void navigateToPlaceDetailScreen();

    void passDataToNextScreen(PlaceItem placeItem);

    void navigateToMenuScreen();
  }
}
