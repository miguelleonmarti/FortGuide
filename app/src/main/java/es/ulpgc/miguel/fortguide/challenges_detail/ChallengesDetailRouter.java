package es.ulpgc.miguel.fortguide.challenges_detail;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class ChallengesDetailRouter implements ChallengesDetailContract.Router {

  public static String TAG = ChallengesDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public ChallengesDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(ChallengesDetailState state) {
    mediator.setChallengesDetailState(state);
  }

  @Override
  public ChallengeItem getDataFromPreviousScreen() {
    ChallengeItem challenge = mediator.getChallengeItem();
    return challenge;
  }
}
