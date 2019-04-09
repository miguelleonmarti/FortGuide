package es.ulpgc.miguel.fortguide.weapon_detail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class WeaponDetailRouter implements WeaponDetailContract.Router {

  public static String TAG = WeaponDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public WeaponDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, WeaponDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(WeaponDetailState state) {
    mediator.setWeaponDetailState(state);
  }

  @Override
  public WeaponDetailState getDataFromPreviousScreen() {
    WeaponDetailState state = mediator.getWeaponDetailState();
    return state;
  }
}
