package es.ulpgc.miguel.fortguide.weapon_detail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class WeaponDetailRouter implements WeaponDetailContract.Router {

  public static String TAG = WeaponDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public WeaponDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void passDataToNextScreen(WeaponDetailState state) {
    mediator.setWeaponDetailState(state);
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }

  @Override
  public WeaponDetailState getDataFromPreviousScreen() {
    WeaponDetailState state = mediator.getWeaponDetailState();
    return state;
  }
}
