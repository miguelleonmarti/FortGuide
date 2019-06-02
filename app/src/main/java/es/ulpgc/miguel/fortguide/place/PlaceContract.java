package es.ulpgc.miguel.fortguide.place;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public interface PlaceContract {

  interface View {
    /**
     * Dependency injection
     * @param presenter Presenter
     */
    void injectPresenter(Presenter presenter);

    /**
     * Display the data that has been fetch on the UI
     * @param viewModel ViewModel
     */
    void displayData(PlaceViewModel viewModel);
  }

  interface Presenter {
    /**
     * Dependency injection
     * @param view View
     */
    void injectView(WeakReference<View> view);

    /**
     * Dependency injection
     * @param model Model
     */
    void injectModel(Model model);

    /**
     * Dependency injection
     * @param router Router
     */
    void injectRouter(Router router);

    /**
     * Fetch data (the list of items) when it is required
     * It is an async task
     */
    void fetchData();

    /**
     * Going to the menu screen when the bananaButton is pressed
     */
    void startMenuScreen();

    /**
     * When an item (place) is pressed it tells the router
     * what to pass to next screen
     * @param placeItem PlaceItem
     */
    void selectPlaceListData(PlaceItem placeItem);

  }

  interface Model {
    /**
     * Calls the repository in order to the fetch data (placeList)
     * It is an async task
     * @param callback GetAdviceListCallback
     */
    void fetchPlaceListData(RepositoryContract.GetPlaceListCallback callback);
  }

  interface Router {
    /**
     * Navigate to the next screen (AdviceDetail)
     */
    void navigateToPlaceDetailScreen();

    /**
     * Used to pass the advice item selected on the list to the
     * next screen
     * @param placeItem PlaceItem
     */
    void passDataToNextScreen(PlaceItem placeItem);

    /**
     * Intent to the menu screen
     */
    void navigateToMenuScreen();

    /**
     * Recovering the advice state (it has the list)
     * in case the fetch data has been done before
     * @return AdviceState
     */
    PlaceState getDataFromPreviousScreen();
  }
}
