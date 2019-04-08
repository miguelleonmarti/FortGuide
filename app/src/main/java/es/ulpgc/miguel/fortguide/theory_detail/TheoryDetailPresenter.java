package es.ulpgc.miguel.fortguide.theory_detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.TheoryItem;

public class TheoryDetailPresenter implements TheoryDetailContract.Presenter {

  public static String TAG = TheoryDetailPresenter.class.getSimpleName();

  private WeakReference<TheoryDetailContract.View> view;
  private TheoryDetailViewModel viewModel;
  private TheoryDetailContract.Model model;
  private TheoryDetailContract.Router router;

  public TheoryDetailPresenter(TheoryDetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<TheoryDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(TheoryDetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(TheoryDetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    TheoryItem item = router.getDataFromPreviousScreen();
    if(item !=null) {
      viewModel.theoryItem = item;
      view.get().displayData(viewModel);

    }
  }

  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }
}
