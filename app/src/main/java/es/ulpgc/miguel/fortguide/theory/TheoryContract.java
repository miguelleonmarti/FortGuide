package es.ulpgc.miguel.fortguide.theory;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.TheoryItem;

public interface TheoryContract {

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
    void displayData(TheoryViewModel viewModel);
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
     * Going to the newTheory screen when the bananaButton is pressed
     */
    void startNewTheoryScreen();

    /**
     * Going to the menu screen when the bananaButton is pressed
     */
    void startMenuScreen();

    /**
     * When an item (theory) is pressed it tells the router
     * what to pass to next screen
     * @param item TheoryItem
     */
    void selectTheoryListData(TheoryItem item);
  }

  interface Model {
    /**
     * Calls the repository in order to the fetch data (theoryList)
     * It is an async task
     * @param callback GetTheoryListCallback
     */
    void fetchTheoryListData(final RepositoryContract.GetTheoryListCallback callback);
  }

  interface Router {

    /**
     * Used to pass the theory item selected on the list to the
     * next screen
     * @param item TheoryItem
     */
    void passDataToTheoryDetailScreen(TheoryItem item);

    /**
     * Recovering the theory state (it has the list)
     * in case the fetch data has been done before
     * @return TheoryState
     */
    TheoryState getDataFromPreviousScreen();

    /**
     * Navigate to the next screen (NewTheory)
     */
    void navigateToNewTheoryScreen();

    /**
     * Navigate to the next screen (TheoryDetail)
     */
    void navigateToTheoryDetailScreen();

    /**
     * Intent to the menu screen
     */
    void navigateToMenuScreen();
  }
}
