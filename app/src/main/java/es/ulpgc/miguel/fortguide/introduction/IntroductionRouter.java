package es.ulpgc.miguel.fortguide.introduction;


import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class IntroductionRouter implements IntroductionContract.Router {

  public static String TAG = IntroductionRouter.class.getSimpleName();

  private AppMediator mediator;

  public IntroductionRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }
}
