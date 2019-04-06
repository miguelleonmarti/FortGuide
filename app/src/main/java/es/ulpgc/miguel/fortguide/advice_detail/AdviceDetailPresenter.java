package es.ulpgc.miguel.fortguide.advice_detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.AdviceItem;

public class AdviceDetailPresenter implements AdviceDetailContract.Presenter {

  public static String TAG = AdviceDetailPresenter.class.getSimpleName();

  private WeakReference<AdviceDetailContract.View> view;
  private AdviceDetailViewModel viewModel;
  private AdviceDetailContract.Model model;
  private AdviceDetailContract.Router router;

  public AdviceDetailPresenter(AdviceDetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AdviceDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AdviceDetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AdviceDetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    AdviceItem item = router.getDataFromPreviousScreen();
    if(item !=null) {
        viewModel.item = item;
        view.get().displayData(viewModel);

    }
  }

  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }
}
