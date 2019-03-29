package es.ulpgc.miguel.fortguide.advice;

import java.lang.ref.WeakReference;

interface AdviceContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AdviceViewModel viewModel);
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
    void navigateToNextScreen();

    void passDataToNextScreen(AdviceState state);

    AdviceState getDataFromPreviousScreen();

    void navigateToMenuScreen();
  }
}
