package es.ulpgc.miguel.fortguide.shop;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public interface ShopContract {

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
    void displayData(ShopViewModel viewModel);
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
  }

  interface Model {
    /**
     * Calls the repository in order to the fetch data (advice list)
     * It is an async task
     * @param callback GetShopListCallback
     */
    void fetchData(RepositoryContract.GetShopListCallback callback);
  }

  interface Router {
    /**
     * Used to pass the advice item selected on the list to the
     * next screen
     * @param state ShopState
     */
    void passDataToNextScreen(ShopState state);

    /**
     * Recovering the shop state (it has the list)
     * in case the fetch data has been done before
     * @return ShopState
     */
    ShopState getDataFromPreviousScreen();

    /**
     * Intent to the menu screen
     */
    void navigateToMenuScreen();
  }
}
