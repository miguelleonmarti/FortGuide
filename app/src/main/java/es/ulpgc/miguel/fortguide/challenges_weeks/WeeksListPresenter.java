package es.ulpgc.miguel.fortguide.challenges_weeks;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.WeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class WeeksListPresenter implements WeeksListContract.Presenter {

  public static String TAG = WeeksListPresenter.class.getSimpleName();

  private WeakReference<WeeksListContract.View> view;
  private WeeksListViewModel viewModel;
  private WeeksListContract.Model model;
  private WeeksListContract.Router router;

  public WeeksListPresenter(WeeksListState state) {
    viewModel = state;
  }

  @Override
  public void fetchChallengeListData() {
    // Log.e(TAG, "fetchData()");

    // call the model
    model.fetchChallengesWeeksListData(new RepositoryContract.GetChallengesWeeksListCallback() {

      @Override
      public void setChallengesWeeksItemList(List<WeeksItem> challengesWeeksList) {
        viewModel.challenges = challengesWeeksList;
        view.get().displayChallengeListData(viewModel);
      }
    });

  }

  @Override
  public void selectChallengeListData(WeeksItem item) {
    router.passDataToChallengeDetailsScreen(item);
    router.navigateToChallengeDetailsScreen();
  }

  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }

  @Override
  public void injectView(WeakReference<WeeksListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(WeeksListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(WeeksListContract.Router router) {
    this.router = router;
  }

}
