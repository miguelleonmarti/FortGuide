package es.ulpgc.miguel.fortguide.weapon;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public interface WeaponContract {

  interface View {
    /**
     * Dependency injection
     * @param presenter Presenter
     */
    void injectPresenter(Presenter presenter);

    /**
     * Dependency injection
     * @param viewModel ViewModel
     */
    void displayData(WeaponViewModel viewModel);
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
     * Fetch the data (list of weapons) by the rarity selected
     * It is an async task
     * @param rarity The rarity of the weapon (common, uncommon, legendary...)
     */
    void fetchData(String rarity);

    /**
     * Save the previous state of the screen when it is rotated
     */
    void refreshUI();

    /**
     * Going to the menu screen when the bananaButton is pressed
     */
    void startMenuScreen();

  }

  interface Model {
    /**
     * Calls the repository in order to the fetch data (weapon list)
     * It is an async task
     * @param rarity The rarity of the weapon (common, uncommon, legendary...)
     * @param callback GetWeaponListCallback
     */
    void fetchData(String rarity, RepositoryContract.GetWeaponListCallback callback);
  }

  interface Router {
    /**
     * Recovering the advice state (which it has the list)
     * in case the fetch data has been done before
     * @return WeaponState
     */
    WeaponState getDataFromPreviousScreen();

    /**
     * Intent to the menu screen
     */
    void navigateToMenuScreen();
  }
}
