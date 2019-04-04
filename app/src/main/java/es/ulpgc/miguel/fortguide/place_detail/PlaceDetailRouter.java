package es.ulpgc.miguel.fortguide.place_detail;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.data.PlaceDetailItem;

public class PlaceDetailRouter implements PlaceDetailContract.Router {

  public static String TAG = PlaceDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public PlaceDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, PlaceDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(PlaceDetailState state) {
    mediator.setPlaceDetailState(state);
  }

  @Override
  public PlaceDetailItem getDataFromPlaceScreen() {
    PlaceDetailItem placeDetailItem = mediator.getPlaceDetailItem();
    return placeDetailItem;
  }
}
