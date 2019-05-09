package es.ulpgc.miguel.fortguide.support;

import java.lang.ref.WeakReference;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.SupportItem;

public interface SupportContract {

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
    void displayData(SupportViewModel viewModel);
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
     * When an item (support or content creator) is pressed it tells the router
     * what to pass to next screen
     * @param item SupportItem
     */
    void selectSupportListData(SupportItem item);
  }

  interface Model {
    /**
     * Calls the repository in order to the fetch data (support list)
     * It is an async task
     * @param callback GetSupportListCallback
     */
    void fetchSupportListData(RepositoryContract.GetSupportListCallback callback);
  }

  interface Router {
    /**
     * Navigate to the next screen (SupportDetail)
     */
    void navigateToSupportProfileScreen();

    /**
     * Used to pass the support item selected on the list to the
     * next screen
     * @param supportItem SupportItem
     */
    void passDataToSupportProfileScreen(SupportItem supportItem);

    /**
     * Intent to the menu screen
     */
    void navigateToMenuScreen();

    /**
     * Recovering the advice state (it has the list)
     * in case the fetch data has been done before
     * @return SupportState
     */
    SupportState getDataFromPreviousScreen();
  }
}
