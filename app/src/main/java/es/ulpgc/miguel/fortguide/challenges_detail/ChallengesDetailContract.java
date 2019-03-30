package es.ulpgc.miguel.fortguide.challenges_detail;

import android.view.MenuItem;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;

interface ChallengesDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayChallengeDetailData(ChallengesDetailViewModel viewModel);

    boolean onOptionsItemSelected(MenuItem item);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchChallengeDetailData();
  }

  interface Model {

  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(ChallengesDetailState state);

    ChallengeItem getDataFromPreviousScreen();
  }
}
