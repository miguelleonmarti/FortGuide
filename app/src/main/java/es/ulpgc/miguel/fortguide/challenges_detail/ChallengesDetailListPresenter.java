package es.ulpgc.miguel.fortguide.challenges_detail;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengesDetailListPresenter implements ChallengesDetailListContract.Presenter {

  public static String TAG = ChallengesDetailListPresenter.class.getSimpleName();

  private WeakReference<ChallengesDetailListContract.View> view;
  private ChallengesDetailListViewModel viewModel;
  private ChallengesDetailListContract.Model model;
  private ChallengesDetailListContract.Router router;

  public ChallengesDetailListPresenter(ChallengesDetailListState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<ChallengesDetailListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ChallengesDetailListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ChallengesDetailListContract.Router router) {
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
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }
}
