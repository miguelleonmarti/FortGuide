package es.ulpgc.miguel.fortguide.challenges_detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public interface ChallengesDetailListContract {

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
    void displayChallengeDetailListData(ChallengesDetailListViewModel viewModel);
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
    void fetchChallengeDetailListData();

    /**
     * Going to the menu screen when the bananaButton is pressed
     */
    void startMenuScreen();
  }

  interface Model {

    /**
     * Calls the repository in order to the fetch challenge detail data (challenge detail)
     * It is an async task
     * @param callback GetChallengeDetailListCallback
     */
    void fetchChallengesDetailData(
        int weekId, RepositoryContract.GetChallengeDetailListCallback callback);
  }

  interface Router {
    /**
     * Intent to the menu screen
     */
    void navigateToMenuScreen();

    /**
     * Recovering the weeks item selected on the previous screen
     * @return ChallengeItem
     */
    int getDataFromWeeksListScreen();
  }
}
