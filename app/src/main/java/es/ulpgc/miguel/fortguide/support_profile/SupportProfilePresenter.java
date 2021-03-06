package es.ulpgc.miguel.fortguide.support_profile;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.SupportItem;

public class SupportProfilePresenter implements SupportProfileContract.Presenter {

  public static String TAG = SupportProfilePresenter.class.getSimpleName();

  private WeakReference<SupportProfileContract.View> view;
  private SupportProfileViewModel viewModel;
  private SupportProfileContract.Model model;
  private SupportProfileContract.Router router;

  public SupportProfilePresenter(SupportProfileState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<SupportProfileContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(SupportProfileContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(SupportProfileContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    SupportItem supportItem = router.getDataFromSupportScreen();
    if (supportItem != null) {
      viewModel.profile = supportItem;
      view.get().displayData(viewModel);
    }
  }

  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }

  @Override
  public void startSocialNetworkScreen(String socialNetwork) {
    switch (socialNetwork) {
      case "instagram":
        router.navigateToSocialNetworkScreen(viewModel.profile.getInstagram());
        break;
      case "twitter":
        router.navigateToSocialNetworkScreen(viewModel.profile.getTwitter());
        break;
      case "twitch":
        router.navigateToSocialNetworkScreen(viewModel.profile.getTwitch());
        break;
      case "youtube":
        router.navigateToSocialNetworkScreen(viewModel.profile.getYoutube());
        break;
      default:
        break;
    }
  }
}
