package es.ulpgc.miguel.fortguide.challenges_weeks;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.challenge.ChallengeRepository;
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
  public void fetchChallengeListData() {
    // Log.e(TAG, "fetchData()");

    // call the model
    model.fetchChallengesWeeksListData(new RepositoryContract.GetChallengesWeeksListCallback() {

      @Override
      public void setChallengesWeeksItemList(List<ChallengesWeeksItem> challengesWeeksList) {
        viewModel.challenges = challengesWeeksList;
        view.get().displayChallengeListData(viewModel);
      }
    });

  }

  @Override
  public void selectChallengeListData(ChallengesWeeksItem item) {
    router.passDataToChallengeDetailsScreen(item);
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
