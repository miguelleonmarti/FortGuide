package es.ulpgc.miguel.fortguide.challenges_detail;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class ChallengesDetailListRouter implements ChallengesDetailListContract.Router {

  public static String TAG = ChallengesDetailListRouter.class.getSimpleName();

  private AppMediator mediator;

  public ChallengesDetailListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }

  @Override
  public int getDataFromWeeksListScreen() {
    return mediator.getWeekId();
  }

}
