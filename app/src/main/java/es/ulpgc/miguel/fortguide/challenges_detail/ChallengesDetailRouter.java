package es.ulpgc.miguel.fortguide.challenges_detail;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
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
  public void passDataToNextScreen(ChallengeItem item) {
    mediator.setChallengeItem(item);
  }

  @Override
  public ChallengesWeeksItem getDataFromWeeksListScreen() {
    ChallengesWeeksItem ChallengesWeeksItem = mediator.getChallengesWeeksItem();
    return ChallengesWeeksItem;
  }

  @Override
  public void navigateToChallengeDetailScreen(){
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context,ChallengesDetailActivity.class);
    context.startActivity(intent);
  }
}
