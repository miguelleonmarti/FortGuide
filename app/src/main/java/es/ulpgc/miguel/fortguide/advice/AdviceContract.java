package es.ulpgc.miguel.fortguide.advice;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public interface AdviceContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AdviceViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
    void selectAdviceListData(AdviceItem item);
    void startMenuScreen();
  }

  interface Model {
    void fetchAdviceListData(RepositoryContract.GetAdviceListCallback callback);
  }

  interface Router {
    void navigateToAdviceDetailScreen();

    void passDataToAdviceDetailScreen(AdviceItem item);

    AdviceState getDataFromPreviousScreen();
    void navigateToMenuScreen();
  }
}
