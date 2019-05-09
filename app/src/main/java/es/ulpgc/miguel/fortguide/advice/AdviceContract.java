package es.ulpgc.miguel.fortguide.advice;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public interface AdviceContract {

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
    void displayData(AdviceViewModel viewModel);
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
     * When an item (advice) is pressed it tells the router
     * what to pass to next screen
     * @param item AdviceItem
     */
    void selectAdviceListData(AdviceItem item);

    /**
     * Going to the menu screen when the bananaButton is pressed
     */
    void startMenuScreen();
  }

  interface Model {
    /**
     * Calls the repository in order to the fetch data (advice list)
     * It is an async task
     * @param callback GetAdviceListCallback
     */
    void fetchAdviceListData(RepositoryContract.GetAdviceListCallback callback);
  }

  interface Router {
    /**
     * Navigate to the next screen (AdviceDetail)
     */
    void navigateToAdviceDetailScreen();

    /**
     * Used to pass the advice item selected on the list to the
     * next screen
     * @param item AdviceItem
     */
    void passDataToAdviceDetailScreen(AdviceItem item);

    /**
     * Recovering the advice state (it has the list)
     * in case the fetch data has been done before
     * @return AdviceState
     */
    AdviceState getDataFromPreviousScreen();

    /**
     * Intent to the menu screen
     */
    void navigateToMenuScreen();
  }
}
