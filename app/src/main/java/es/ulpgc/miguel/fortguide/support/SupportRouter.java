package es.ulpgc.miguel.fortguide.support;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;
import es.ulpgc.miguel.fortguide.support_profile.SupportProfileActivity;

public class SupportRouter implements SupportContract.Router {

  public static String TAG = SupportRouter.class.getSimpleName();

  private AppMediator mediator;

  public SupportRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToSupportProfileScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, SupportProfileActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToSupportProfileScreen(SupportItem item) {
    mediator.setSupportItem(item);
  }

  @Override
  public SupportState getDataFromPreviousScreen() {
    return mediator.getSupportState();
  }
}
