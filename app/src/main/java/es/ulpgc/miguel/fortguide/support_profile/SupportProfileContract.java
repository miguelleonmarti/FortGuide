package es.ulpgc.miguel.fortguide.support_profile;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.SupportItem;

public interface SupportProfileContract {

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
    void displayData(SupportProfileViewModel viewModel);
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
     * Recovering the SupportItem from the router
     */
    void fetchData();

    /**
     * Going to the menu screen when the bananaButton is pressed
     */
    void startMenuScreen();

    /**
     * Going to the social network screen when a button is pressed
     * @param socialNetwork (String) It can be twitter, twitch, youtube...
     */
    void startSocialNetworkScreen(String socialNetwork);
  }

  interface Model {
  }

  interface Router {
    /**
     * Set the SupportProfileState
     * @param state SupportProfileState
     */
    void passDataToNextScreen(SupportProfileState state);

    /**
     * Recovering the support item selected on the previous screen
     * @return SupportItem
     */
    SupportItem getDataFromSupportScreen();

    /**
     * Intent to the menu screen
     */
    void navigateToMenuScreen();

    /**
     * Intent to the social network app or website
     * @param socialNetwork (String) the social network selected (twitter, twitch, youtube...)
     */
    void navigateToSocialNetworkScreen(String socialNetwork);
  }
}
