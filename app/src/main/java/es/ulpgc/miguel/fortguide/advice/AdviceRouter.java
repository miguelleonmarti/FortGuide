package es.ulpgc.miguel.fortguide.advice;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import es.ulpgc.miguel.fortguide.advice_detail.AdviceDetailActivity;
import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class AdviceRouter implements AdviceContract.Router {

  public static String TAG = AdviceRouter.class.getSimpleName();

  private AppMediator mediator;

  public AdviceRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToAdviceDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdviceDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToAdviceDetailScreen(AdviceItem item) {
    mediator.setAdvice(item);
  }

  @Override
  public AdviceState getDataFromPreviousScreen() {
    AdviceState state = mediator.getAdviceState();
    return state;
  }
  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }
}
