package es.ulpgc.miguel.fortguide.challenges_weeks;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
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
  public void fetchWeeksListData() {
    // Log.e(TAG, "fetchData()");

    // call the model
    model.fetchWeeksListData(new RepositoryContract.GetWeeksListCallback() {

      @Override
      public void setWeeksItemList(List<ChallengesWeeksItem> WeeksList) {
        viewModel.challengesWeeksItemList = WeeksList;

        view.get().displayWeeksListData(viewModel);
      }
    });

  }

  @Override
  public void selectWeeksListData(ChallengesWeeksItem item) {
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
