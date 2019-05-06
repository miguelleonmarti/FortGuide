package es.ulpgc.miguel.fortguide.weapon;

    import android.util.Log;

    import java.lang.ref.WeakReference;
    import java.util.List;

    import es.ulpgc.miguel.fortguide.data.RepositoryContract;
    import es.ulpgc.miguel.fortguide.data.WeaponItem;

public class WeaponPresenter implements WeaponContract.Presenter {

  public static String TAG = WeaponPresenter.class.getSimpleName();

  private WeakReference<WeaponContract.View> view;
  private WeaponViewModel viewModel;
  private WeaponContract.Model model;
  private WeaponContract.Router router;

  public WeaponPresenter(WeaponState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<WeaponContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(WeaponContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(WeaponContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData(String rarity) {
    Log.e(TAG, "fetchData()");
    final WeaponState state = router.getDataFromPreviousScreen();
    if (state.weaponItemList != null && state.weaponItemList.get(0).getRarity().equals(rarity)) {
      viewModel.weaponItemList = state.weaponItemList;
      view.get().displayData(viewModel);
    } else {
      model.fetchData(rarity, new RepositoryContract.GetWeaponListCallback() {
        @Override
        public void setWeaponList(List<WeaponItem> weaponList) {
          viewModel.weaponItemList = weaponList;
          state.weaponItemList = viewModel.weaponItemList;
          view.get().displayData(viewModel);
        }
      });
    }
  }

  @Override
  public void refreshUI() {
    Log.e(TAG, "refreshUI()");
    WeaponState state = router.getDataFromPreviousScreen();
    if (state.weaponItemList != null) {
      viewModel.weaponItemList = state.weaponItemList;
      view.get().displayData(viewModel);
    }
  }

  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }

}
