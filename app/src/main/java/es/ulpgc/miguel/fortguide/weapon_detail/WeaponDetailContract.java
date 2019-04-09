package es.ulpgc.miguel.fortguide.weapon_detail;

import java.lang.ref.WeakReference;

interface WeaponDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(WeaponDetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(WeaponDetailState state);

    WeaponDetailState getDataFromPreviousScreen();
  }
}
