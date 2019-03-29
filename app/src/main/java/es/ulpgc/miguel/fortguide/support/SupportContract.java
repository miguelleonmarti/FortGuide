package es.ulpgc.miguel.fortguide.support;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import es.ulpgc.miguel.fortguide.data.SupportItem;

interface SupportContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(SupportViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void startMenuScreen();

    void selectCategoryListData(SupportItem item);
  }

  interface Model {
    ArrayList<SupportItem> fetchData();
  }

  interface Router {
    void navigateToSupportProfileScreen();

    void passDataToSupportProfileScreen(SupportItem supportItem);

    void navigateToMenuScreen();
  }
}
