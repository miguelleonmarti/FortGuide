package es.ulpgc.miguel.fortguide.theory_detail;

import android.content.Intent;
import android.content.Context;


import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.data.TheoryItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class TheoryDetailRouter implements TheoryDetailContract.Router {

  public static String TAG = TheoryDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public TheoryDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public TheoryItem getDataFromPreviousScreen() {
    TheoryItem item = mediator.getTheory();
    return item;
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }

}
