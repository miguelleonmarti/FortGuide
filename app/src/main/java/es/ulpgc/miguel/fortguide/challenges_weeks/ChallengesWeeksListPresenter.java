package es.ulpgc.miguel.fortguide.challenges_weeks;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengesWeeksListPresenter implements ChallengesWeeksListContract.Presenter {

  public static String TAG = ChallengesWeeksListPresenter.class.getSimpleName();

  private WeakReference<ChallengesWeeksListContract.View> view;
  private ChallengesWeeksListViewModel viewModel;
  private ChallengesWeeksListContract.Model model;
  private ChallengesWeeksListContract.Router router;

  public ChallengesWeeksListPresenter(ChallengesWeeksListState state) {
    viewModel = state;
  }

  @Override
  public void fetchWeeksListData() {
    // Log.e(TAG, "fetchData()");

    // call the model
    model.fetchWeeksListData(new RepositoryContract.GetWeeksListCallback() {
      @Override
      public void setWeeksItemList(List<ChallengesWeeksItem> weeksList) {
        viewModel.challengesWeeksItemList = weeksList;
        view.get().displayWeeksListData(viewModel);
      }
    });

  }

  @Override
  public void selectWeeksListData(int weekId) {
    router.passDataToChallengeDetailsScreen(weekId);
    router.navigateToChallengeDetailsScreen();
  }


  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }

  @Override
  public void injectView(WeakReference<ChallengesWeeksListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ChallengesWeeksListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ChallengesWeeksListContract.Router router) {
    this.router = router;
  }

}
