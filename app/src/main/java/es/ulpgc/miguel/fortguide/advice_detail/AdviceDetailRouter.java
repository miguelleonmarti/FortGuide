package es.ulpgc.miguel.fortguide.advice_detail;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class AdviceDetailRouter implements AdviceDetailContract.Router {

  public static String TAG = AdviceDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public AdviceDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdviceDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(AdviceDetailState state) {
    mediator.setAdviceDetailState(state);
  }

  @Override
  public AdviceDetailState getDataFromPreviousScreen() {
    AdviceDetailState state = mediator.getAdviceDetailState();
    return state;
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }
}
