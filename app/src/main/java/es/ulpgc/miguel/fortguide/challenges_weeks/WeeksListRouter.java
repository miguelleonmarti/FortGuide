package es.ulpgc.miguel.fortguide.challenges_weeks;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.challenges_detail.ChallengesDetailActivity;
import es.ulpgc.miguel.fortguide.data.WeeksItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class WeeksListRouter implements WeeksListContract.Router {

  public static String TAG = WeeksListRouter.class.getSimpleName();

  private AppMediator mediator;

  public WeeksListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToChallengeDetailsScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ChallengesDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToChallengeDetailsScreen(WeeksItem item) {
    mediator.setWeeksItem(item);
  }
}