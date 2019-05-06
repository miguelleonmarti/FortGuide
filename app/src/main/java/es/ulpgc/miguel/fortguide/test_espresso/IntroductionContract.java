package es.ulpgc.miguel.fortguide.test_espresso;

import java.lang.ref.WeakReference;

public interface IntroductionContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(IntroductionViewModel viewModel);
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
    void passDataToNextScreen(IntroductionState state);

    IntroductionState getDataFromPreviousScreen();

    void navigateToMenuScreen();
  }
}
