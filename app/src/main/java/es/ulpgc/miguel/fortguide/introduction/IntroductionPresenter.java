package es.ulpgc.miguel.fortguide.introduction;

import java.lang.ref.WeakReference;

public class IntroductionPresenter implements IntroductionContract.Presenter {

  public static String TAG = IntroductionPresenter.class.getSimpleName();

  private WeakReference<IntroductionContract.View> view;
  private IntroductionViewModel viewModel;
  private IntroductionContract.Model model;
  private IntroductionContract.Router router;

  public IntroductionPresenter(IntroductionState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<IntroductionContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(IntroductionContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(IntroductionContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");


    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }
}
