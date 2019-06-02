package es.ulpgc.miguel.fortguide.advice_detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.AdviceItem;

public interface AdviceDetailContract {

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
    void displayData(AdviceDetailViewModel viewModel);
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
     * Recovering the AdviceItem from the router
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
     * Recovering the advice item selected on the previous screen
     * @return AdviceItem
     */
    AdviceItem getDataFromPreviousScreen();

    /**
     * Intent to the menu screen
     */
    void navigateToMenuScreen();
  }
}
