package es.ulpgc.miguel.fortguide.challenges_weeks;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;

interface ChallengesWeeksListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayChallengeListData(ChallengesWeeksListViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchChallengeListData();

    void selectChallengeListData(ChallengesWeeksItem item);

    void startMenuScreen();
  }

  interface Model {
    List<ChallengesWeeksItem> fetchChallengeListData();
  }

  interface Router {
    void navigateToChallengeDetailsScreen();

    void passDataToChallengeDetailsScreen(ChallengesWeeksItem item);

    ChallengesWeeksListState getDataFromPreviousScreen();

    void navigateToMenuScreen();
  }
}
