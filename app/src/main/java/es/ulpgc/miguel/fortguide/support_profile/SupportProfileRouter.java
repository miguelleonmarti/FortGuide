package es.ulpgc.miguel.fortguide.support_profile;

import android.content.Intent;
import android.content.Context;
import android.net.Uri;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class SupportProfileRouter implements SupportProfileContract.Router {

  public static String TAG = SupportProfileRouter.class.getSimpleName();

  private AppMediator mediator;

  public SupportProfileRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToSocialNetworkScreen(String socialNetwork) {
    Uri uri = Uri.parse(socialNetwork);
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    context.startActivity(intent);
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(SupportProfileState state) {
    mediator.setSupportProfileState(state);
  }

  @Override
  public SupportItem getDataFromSupportScreen() {
    SupportItem supportItem = mediator.getSupportItem();
    return supportItem;
  }
}
