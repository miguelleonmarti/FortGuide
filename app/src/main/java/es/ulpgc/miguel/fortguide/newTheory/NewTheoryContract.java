package es.ulpgc.miguel.fortguide.newTheory;

import java.lang.ref.WeakReference;

public interface NewTheoryContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(NewTheoryViewModel viewModel);
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

    void passDataToNextScreen(NewTheoryState state);

    NewTheoryState getDataFromPreviousScreen();

    void navigateToMenuScreen();
  }
}
