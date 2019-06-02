package es.ulpgc.miguel.fortguide.menu;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public interface MenuContract {

  interface View {
    /**
     * Dependency injection
     * @param presenter Presenter
     */
    void injectPresenter(Presenter presenter);

    /**
     * Display the data that has been fetch on the UI
     * @param viewModel ViewModel
     */
    void displayData(MenuViewModel viewModel);
  }

  interface Presenter {
    /**
     * Dependency injection
     * @param view View
     */
    void injectView(WeakReference<View> view);

    /**
     * Dependency injection
     * @param model Model
     */
    void injectModel(Model model);

    /**
     * Dependency injection
     * @param router Router
     */
    void injectRouter(Router router);

    /**
     * Fetch data when it is required
     * It is an async task
     */
    void fetchData(); //todo: revisar

    /**
     * Going to the advice screen when the AdviceButton is pressed
     */
    void startAdviceScreen();

    /**
     * Going to the challenge screen when the ChallengeButton is pressed
     */
    void startChallengeScreen();

    /**
     * Going to the place screen when the PlaceButton is pressed
     */
    void startPlaceScreen();

    /**
     * Going to the shop screen when the ShopButton is pressed
     */
    void startShopScreen();

    /**
     * Going to the support screen when the SupportButton is pressed
     */
    void startSupportScreen();

    /**
     * Going to the theory screen when the TheoryButton is pressed
     */
    void startTheoryScreen();

    /**
     * Going to the weapon screen when the WeaponButton is pressed
     */
    void startWeaponScreen();

    /**
     * Going to the contact screen when the ContactButton is pressed
     */
    void startContactScreen();
  }

  interface Model {
    /**
     * Calls the repository in order to the fetch data (advice list)
     * It is an async task
     * @param callback GetServerStatusCallback
     */
    void fetchData(RepositoryContract.GetServerStatusCallback callback);
  }

  interface Router {
    /**
     * Used to pass the menu state
     * @param state MenuState
     */
    void passDataToNextScreen(MenuState state);

    /**
     * Recovering the menu state
     * @return MenuState
     */
    MenuState getDataFromPreviousScreen();

    /**
     * Intent to the weapon screen
     */
    void navigateToWeaponScreen();

    /**
     * Intent to the theory screen
     */
    void navigateToTheoryScreen();

    /**
     * Intent to the support screen
     */
    void navigateToSupportScreen();

    /**
     * Intent to the shop screen
     */
    void navigateToShopScreen();

    /**
     * Intent to the place screen
     */
    void navigateToPlaceScreen();

    /**
     * Intent to the challenge screen
     */
    void navigateToChallengeScreen();

    /**
     * Intent to the advice screen
     */
    void navigateToAdviceScreen();

    /**
     * Intent to the contact screen
     */
    void navigateToContactScreen();
  }
}
