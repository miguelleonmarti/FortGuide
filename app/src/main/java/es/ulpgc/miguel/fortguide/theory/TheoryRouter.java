package es.ulpgc.miguel.fortguide.theory;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.data.TheoryItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;
import es.ulpgc.miguel.fortguide.newTheory.NewTheoryActivity;
import es.ulpgc.miguel.fortguide.theory_detail.TheoryDetailActivity;

public class TheoryRouter implements TheoryContract.Router {

  public static String TAG = TheoryRouter.class.getSimpleName();

  private AppMediator mediator;

  public TheoryRouter(AppMediator mediator) {
    this.mediator = mediator;
  }


  @Override
  public void passDataToTheoryDetailScreen(TheoryItem item) {
    mediator.setTheory(item);
  }

  @Override
  public TheoryState getDataFromPreviousScreen() {
    TheoryState state = mediator.getTheoryState();
    return state;
  }

  @Override
  public void navigateToNewTheoryScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, NewTheoryActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToTheoryDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, TheoryDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }
}
