package es.ulpgc.miguel.fortguide.advice_detail;

import android.content.Context;
import android.content.Intent;
import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class AdviceDetailRouter implements AdviceDetailContract.Router {

  public static String TAG = AdviceDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public AdviceDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public AdviceItem getDataFromPreviousScreen() {
    AdviceItem item = mediator.getAdvice();
    return item;
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }
}
