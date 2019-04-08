package es.ulpgc.miguel.fortguide.theory;

import java.lang.ref.WeakReference;

public interface TheoryContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(TheoryViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void startNewTheoryScreen();

    void startMenuScreen();
  }

  interface Model {
    String fetchData();
  }

  interface Router {

    void passDataToNextScreen(TheoryState state);

    TheoryState getDataFromPreviousScreen();

    void navigateToNewTheoryScreen();

    void navigateToMenuScreen();
  }
}
