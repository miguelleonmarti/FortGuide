package es.ulpgc.miguel.fortguide.challenges_weeks;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.WeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

interface WeeksListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayChallengeListData(WeeksListViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void fetchChallengeListData();
    void selectChallengeListData(WeeksItem item);
    void startMenuScreen();
  }

  interface Model {
    void fetchChallengesWeeksListData(RepositoryContract.GetChallengesWeeksListCallback callback);
  }

  interface Router {
    void navigateToChallengeDetailsScreen();
    void passDataToChallengeDetailsScreen(WeeksItem item);
    void navigateToMenuScreen();
  }
}
