package es.ulpgc.miguel.fortguide.support;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.SupportItem;

public class SupportPresenter implements SupportContract.Presenter {

  public static String TAG = SupportPresenter.class.getSimpleName();

  private WeakReference<SupportContract.View> view;
  private SupportViewModel viewModel;
  private SupportContract.Model model;
  private SupportContract.Router router;

  public SupportPresenter(SupportState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<SupportContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(SupportContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(SupportContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");
    model.fetchSupportListData(new RepositoryContract.GetSupportListCallback() {
      @Override
      public void setSupportList(List<SupportItem> supportList) {
        viewModel.profiles = supportList;
        view.get().displayData(viewModel);
      }
    });
  }

  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }

  @Override
  public void selectSupportListData(SupportItem item) {
    router.navigateToSupportProfileScreen();
    router.passDataToSupportProfileScreen(item);
  }
}
