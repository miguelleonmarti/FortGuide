package es.ulpgc.miguel.fortguide.support;

import java.lang.ref.WeakReference;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.SupportItem;

public interface SupportContract {

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

    void selectSupportListData(SupportItem item);
  }

  interface Model {
    void fetchSupportListData(RepositoryContract.GetSupportListCallback callback);
  }

  interface Router {
    void navigateToSupportProfileScreen();

    void passDataToSupportProfileScreen(SupportItem supportItem);

    void navigateToMenuScreen();
  }
}
