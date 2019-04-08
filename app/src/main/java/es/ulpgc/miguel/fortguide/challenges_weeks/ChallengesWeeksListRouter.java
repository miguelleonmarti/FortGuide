package es.ulpgc.miguel.fortguide.challenges_weeks;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.challenges_detail.ChallengesDetailActivity;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class ChallengesWeeksListRouter implements ChallengesWeeksListContract.Router {

  public static String TAG = ChallengesWeeksListRouter.class.getSimpleName();

  private AppMediator mediator;

  public ChallengesWeeksListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToChallengeDetailsScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ChallengesDetailActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToChallengeDetailsScreen(ChallengesWeeksItem item) {
    mediator.setChallengesWeeksItem(item);
  }
}
