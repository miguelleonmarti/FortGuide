package es.ulpgc.miguel.fortguide.challenges_weeks;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public interface ChallengesWeeksListContract {

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
    void displayWeeksListData(ChallengesWeeksListViewModel viewModel);
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
    void fetchWeeksListData();

    /**
     * When an item (challengeWeeks) is pressed it tells the router
     * what to pass to next screen
     * @param weekId ChallengeItem
     */
    void selectWeeksListData(int weekId);

    /**
     * Going to the menu screen when the bananaButton is pressed
     */
    void startMenuScreen();
  }

  interface Model {

    /**
     * Calls the repository in order to the fetch data (weeks list)
     * It is an async task
     * @param callback GetWeeksListCallback
     */
    void fetchWeeksListData(RepositoryContract.GetWeeksListCallback callback);
  }

  interface Router {

    /**
     * Navigate to the next screen (ChallengesDetail)
     */
    void navigateToChallengeDetailsScreen();

    /**
     * Used to pass the id of the week item selected on the list to the
     * next screen
     * @param weekId ChallengeItem
     */
    void passDataToChallengeDetailsScreen(int weekId);

    /**
     * Intent to the menu screen
     */
    void navigateToMenuScreen();
  }
}
