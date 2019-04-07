package es.ulpgc.miguel.fortguide.support_profile;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.SupportItem;

public interface SupportProfileContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(SupportProfileViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void startMenuScreen();

    void startSocialNetworkScreen(String socialNetwork);
  }

  interface Model {
    String fetchData();
  }

  interface Router {

    void passDataToNextScreen(SupportProfileState state);

    SupportItem getDataFromSupportScreen();

    void navigateToMenuScreen();

    void navigateToSocialNetworkScreen(String socialNetwork);
  }
}
