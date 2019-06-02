package es.ulpgc.miguel.fortguide.place_detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.PlaceItem;

public interface PlaceDetailContract {

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
    void displayPlaceDetailData(PlaceDetailViewModel viewModel);
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
     * If there is a PlaceItem on AppMediator it shows it
     */
    void fetchPlaceDetailData();

    /**
     * Going to the menu screen when the bananaButton is pressed
     */
    void startMenuScreen();
  }

  interface Model {

  }

  interface Router {
    void navigateToMenuScreen();

    /**
     * Used to pass the place item to the AppMediator
     * @param state PlaceDetailState
     */
    void passDataToNextScreen(PlaceDetailState state);

    /**
     * Recovering the place item from the AppMediator
     * @return PlaceItem
     */
    PlaceItem getDataFromPlaceScreen();
  }
}
