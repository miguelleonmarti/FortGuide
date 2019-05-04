package es.ulpgc.miguel.fortguide.menu;

import android.content.Intent;
import android.content.Context;
import android.net.Uri;

import es.ulpgc.miguel.fortguide.R;
import es.ulpgc.miguel.fortguide.advice.AdviceActivity;
import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.challenges_weeks.ChallengesWeeksListActivity;
import es.ulpgc.miguel.fortguide.place.PlaceActivity;
import es.ulpgc.miguel.fortguide.shop.ShopActivity;
import es.ulpgc.miguel.fortguide.support.SupportActivity;
import es.ulpgc.miguel.fortguide.theory.TheoryActivity;
import es.ulpgc.miguel.fortguide.weapon.WeaponActivity;

public class MenuRouter implements MenuContract.Router {

  public static String TAG = MenuRouter.class.getSimpleName();

  private AppMediator mediator;

  public MenuRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void passDataToNextScreen(MenuState state) {
    mediator.setMenuState(state);
  }

  @Override
  public MenuState getDataFromPreviousScreen() {
    MenuState state = mediator.getMenuState();
    return state;
  }

  //------ navigate to

  @Override
  public void navigateToWeaponScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, WeaponActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToTheoryScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, TheoryActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToSupportScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, SupportActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToShopScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ShopActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToPlaceScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, PlaceActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToChallengeScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ChallengesWeeksListActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToAdviceScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdviceActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToContactScreen() {
    Context context = mediator.getApplicationContext();
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","app.kdm@gmail.com", null));
    context.startActivity(emailIntent);
  }

}
