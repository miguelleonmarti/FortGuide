package es.ulpgc.miguel.fortguide.challenges_detail;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengesDetailPresenter implements ChallengesDetailContract.Presenter {

  public static String TAG = ChallengesDetailPresenter.class.getSimpleName();

  private WeakReference<ChallengesDetailContract.View> view;
  private ChallengesDetailViewModel viewModel;
  private ChallengesDetailContract.Model model;
  private ChallengesDetailContract.Router router;

  public ChallengesDetailPresenter(ChallengesDetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<ChallengesDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ChallengesDetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ChallengesDetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchChallengeDetailListData() {
    Log.e(TAG, "fetchChallengeDetailListData()");

    // set passed state
    ChallengesWeeksItem item = router.getDataFromWeeksListScreen();

    if (item != null) {
      viewModel.challengesWeeksItem = item;
    }

    //call the model
    model.fetchChallengesDetailData(viewModel.challengesWeeksItem,
        new RepositoryContract.GetChallengeDetailListCallback() {

          @Override
          public void setChallengeDetailList(List<ChallengeItem> challengeItems) {
            viewModel.challengeItemList = challengeItems;

            view.get().displayChallengeDetailListData(viewModel);
          }
        });
  }

  @Override
  public void selectChallengeDetailListData(ChallengeItem item) {
    router.passDataToNextScreen(item);
    router.navigateToChallengeDetailScreen();
  }


  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }
}
