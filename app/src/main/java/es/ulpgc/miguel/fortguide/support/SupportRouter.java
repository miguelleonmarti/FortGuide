package es.ulpgc.miguel.fortguide.support;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class SupportRouter implements SupportContract.Router {

    public static String TAG = SupportRouter.class.getSimpleName();

    private AppMediator mediator;

    public SupportRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, SupportActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(SupportState state) {
        mediator.setSupportState(state);
    }

    @Override
    public SupportState getDataFromPreviousScreen() {
        SupportState state = mediator.getSupportState();
        return state;
    }
}
