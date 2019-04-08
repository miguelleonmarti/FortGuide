package es.ulpgc.miguel.fortguide.advice_detail;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.AdviceItem;

public interface AdviceDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AdviceDetailViewModel viewModel);
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

    AdviceItem getDataFromPreviousScreen();

    void navigateToMenuScreen();
  }
}
