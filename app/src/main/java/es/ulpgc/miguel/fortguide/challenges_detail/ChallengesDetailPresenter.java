package es.ulpgc.miguel.fortguide.challenges_detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;

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
  public void fetchChallengeDetailData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    ChallengeItem challenge = router.getDataFromPreviousScreen();
    if(challenge != null){
      viewModel.challenge = challenge;
    }

    view.get().displayChallengeDetailData(viewModel);
  }


}
