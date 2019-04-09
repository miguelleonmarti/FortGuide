package es.ulpgc.miguel.fortguide.weapon;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;
import es.ulpgc.miguel.fortguide.weapon_detail.WeaponDetailActivity;

public class WeaponRouter implements WeaponContract.Router {

  public static String TAG = WeaponRouter.class.getSimpleName();

  private AppMediator mediator;

  public WeaponRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToWeaponDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, WeaponDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToWeaponDetailScreen(WeaponState state) {
    mediator.setWeaponState(state);
  }

  @Override
  public WeaponState getDataFromPreviousScreen() {
    WeaponState state = mediator.getWeaponState();
    return state;
  }
}
