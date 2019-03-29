package es.ulpgc.miguel.fortguide.menu;

import java.lang.ref.WeakReference;

public interface MenuContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MenuViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void startAdviceScreen();

    void startChallengeScreen();

    void startPlaceScreen();

    void startShopScreen();

    void startSupportScreen();

    void startTheoryScreen();

    void startWeaponScreen();
  }

  interface Model {
    String fetchData();
  }

  interface Router {

    void passDataToNextScreen(MenuState state);

    MenuState getDataFromPreviousScreen();

    void navigateToWeaponScreen();

    void navigateToTheoryScreen();

    void navigateToSupportScreen();

    void navigateToShopScreen();

    void navigateToPlaceScreen();

    void navigateToChallengeScreen();

    void navigateToAdviceScreen();
  }
}
