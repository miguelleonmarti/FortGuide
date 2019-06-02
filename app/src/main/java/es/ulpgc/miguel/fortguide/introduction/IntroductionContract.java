package es.ulpgc.miguel.fortguide.introduction;

import java.lang.ref.WeakReference;

public interface IntroductionContract {

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
    void displayData(IntroductionViewModel viewModel);
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
    void fetchData();

    /**
     * Going to the menu screen when the bananaButton is pressed
     */
    void startMenuScreen();
  }

  interface Model {

  }

  interface Router {

    /**
     * Navigate to the next screen (Menu)
     */
    void navigateToMenuScreen();
  }
}
