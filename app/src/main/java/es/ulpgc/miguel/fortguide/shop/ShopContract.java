package es.ulpgc.miguel.fortguide.shop;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public interface ShopContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(ShopViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void startMenuScreen();
  }

  interface Model {
    void fetchData(RepositoryContract.GetShopListCallback callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(ShopState state);

    ShopState getDataFromPreviousScreen();

    void navigateToMenuScreen();
  }
}
