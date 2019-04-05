package es.ulpgc.miguel.fortguide.place_detail;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.data.PlaceDetailItem;
import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class PlaceDetailRouter implements PlaceDetailContract.Router {

  public static String TAG = PlaceDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public PlaceDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(PlaceDetailState state) {
    mediator.setPlaceDetailState(state);
  }

  @Override
  public PlaceItem getDataFromPlaceScreen() {
    PlaceItem placeItem = mediator.getPlaceItem();
    return placeItem;
  }
}
