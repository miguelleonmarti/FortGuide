package es.ulpgc.miguel.fortguide.theory_detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.TheoryItem;

public interface TheoryDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(TheoryDetailViewModel viewModel);
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

    TheoryItem getDataFromPreviousScreen();

    void navigateToMenuScreen();
  }
}
