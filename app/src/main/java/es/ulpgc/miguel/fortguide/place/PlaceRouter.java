package es.ulpgc.miguel.fortguide.place;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;
import es.ulpgc.miguel.fortguide.place_detail.PlaceDetailActivity;

public class PlaceRouter implements PlaceContract.Router {

  public static String TAG = PlaceRouter.class.getSimpleName();

  private AppMediator mediator;

  public PlaceRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToPlaceDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, PlaceDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MenuActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(PlaceItem placeItem) {
    mediator.setPlaceItem(placeItem);
  }

  @Override
  public PlaceState getDataFromPreviousScreen() {
    PlaceState state = mediator.getPlaceState();
    return state;
  }
}
