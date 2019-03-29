package es.ulpgc.miguel.fortguide.challenges;

import android.content.Intent;
import android.content.Context;
import android.view.Menu;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.challenge.ChallengesDetailActivity;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class ChallengeListRouter implements ChallengeListContract.Router {

  public static String TAG = ChallengeListRouter.class.getSimpleName();

  private AppMediator mediator;

  public ChallengeListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToChallengeDetailsScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ChallengesDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToChallengeDetailsScreen(ChallengeItem item) {
    mediator.setChallengeItem(item);
  }


  @Override
  public ChallengeListState getDataFromPreviousScreen() {
    ChallengeListState state = mediator.getChallengeListState();
    return state;
  }


  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }
}
