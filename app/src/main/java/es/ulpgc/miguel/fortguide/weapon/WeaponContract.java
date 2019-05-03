package es.ulpgc.miguel.fortguide.weapon;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public interface WeaponContract {

  interface View {
    void injectPresenter(Presenter presenter);
    void displayData(WeaponViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);
    void fetchData();
    void startMenuScreen();

  }

  interface Model {
    void fetchData(RepositoryContract.GetWeaponListCallback callback);
  }

  interface Router {
    WeaponState getDataFromPreviousScreen();
    void navigateToMenuScreen();
  }
}
