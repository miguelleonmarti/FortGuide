package es.ulpgc.miguel.fortguide.place;

import android.content.Intent;
import android.content.Context;

public class PlaceRouter implements PlaceContract.Router {

    public static String TAG = PlaceRouter.class.getSimpleName();

    private AppMediator mediator;

    public PlaceRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, PlaceActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(PlaceState state) {
        mediator.setPlaceState(state);
    }

    @Override
    public PlaceState getDataFromPreviousScreen() {
        PlaceState state = mediator.getPlaceState();
        return state;
    }
}
