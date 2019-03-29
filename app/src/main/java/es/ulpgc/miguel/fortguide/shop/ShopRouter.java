package es.ulpgc.miguel.fortguide.shop;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class ShopRouter implements ShopContract.Router {

  public static String TAG = ShopRouter.class.getSimpleName();

  private AppMediator mediator;

  public ShopRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ShopActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(ShopState state) {
    mediator.setShopState(state);
  }

  @Override
  public ShopState getDataFromPreviousScreen() {
    ShopState state = mediator.getShopState();
    return state;
  }
}
