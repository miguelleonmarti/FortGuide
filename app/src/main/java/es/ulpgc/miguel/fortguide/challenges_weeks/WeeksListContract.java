package es.ulpgc.miguel.fortguide.challenges_weeks;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

interface WeeksListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayWeeksListData(WeeksListViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void fetchWeeksListData();
    void selectWeeksListData(ChallengesWeeksItem item);
    void startMenuScreen();
  }

  interface Model {
    void fetchWeeksListData(RepositoryContract.GetWeeksListCallback callback);
  }

  interface Router {
    void navigateToChallengeDetailsScreen();
    void passDataToChallengeDetailsScreen(ChallengesWeeksItem item);
    void navigateToMenuScreen();
  }
}
