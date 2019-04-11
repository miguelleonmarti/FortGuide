package es.ulpgc.miguel.fortguide.challenges_detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public interface ChallengesDetailListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayChallengeDetailListData(ChallengesDetailListViewModel viewModel);


  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchChallengeDetailListData();

    void startMenuScreen();
  }

  interface Model {

    void fetchChallengesDetailData(
        ChallengesWeeksItem challengesWeeksItem, RepositoryContract.GetChallengeDetailListCallback callback);
  }

  interface Router {
     void navigateToMenuScreen();

     void passDataToNextScreen(ChallengeItem item);

     void navigateToChallengeDetailScreen();

    ChallengesWeeksItem getDataFromWeeksListScreen();
  }
}
