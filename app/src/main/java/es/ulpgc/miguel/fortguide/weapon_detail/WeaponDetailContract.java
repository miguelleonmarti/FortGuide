package es.ulpgc.miguel.fortguide.weapon_detail;

import java.lang.ref.WeakReference;

public interface WeaponDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(WeaponDetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void startMenuScreen();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void passDataToNextScreen(WeaponDetailState state);

    void navigateToMenuScreen();

    WeaponDetailState getDataFromPreviousScreen();
  }
}
