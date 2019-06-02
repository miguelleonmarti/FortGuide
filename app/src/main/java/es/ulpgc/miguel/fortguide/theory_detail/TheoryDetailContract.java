package es.ulpgc.miguel.fortguide.theory_detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.TheoryItem;

public interface TheoryDetailContract {

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
    void displayData(TheoryDetailViewModel viewModel);
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
     * If there is a TheoryItem on AppMediator it shows it
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
     * Recovering the theory item selected on the previous screen
     * @return TheoryItem
     */
    TheoryItem getDataFromPreviousScreen();

    /**
     * Intent to the menu screen
     */
    void navigateToMenuScreen();
  }
}
