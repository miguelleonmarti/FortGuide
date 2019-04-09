package es.ulpgc.miguel.fortguide.weapon;

import java.lang.ref.WeakReference;

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
    void startWeaponDetailScreen();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToWeaponDetailScreen();

    void passDataToWeaponDetailScreen(WeaponState state);

    WeaponState getDataFromPreviousScreen();

    void navigateToMenuScreen();
  }
}
