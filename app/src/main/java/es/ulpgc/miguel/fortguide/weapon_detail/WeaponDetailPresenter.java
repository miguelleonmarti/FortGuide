package es.ulpgc.miguel.fortguide.weapon_detail;


import java.lang.ref.WeakReference;

public class WeaponDetailPresenter implements WeaponDetailContract.Presenter {

  public static String TAG = WeaponDetailPresenter.class.getSimpleName();

  private WeakReference<WeaponDetailContract.View> view;
  private WeaponDetailViewModel viewModel;
  private WeaponDetailContract.Model model;
  private WeaponDetailContract.Router router;

  public WeaponDetailPresenter(WeaponDetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<WeaponDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(WeaponDetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(WeaponDetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    WeaponDetailState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void startMenuScreen(){
    router.navigateToMenuScreen();
  }

}
