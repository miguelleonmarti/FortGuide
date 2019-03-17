package es.ulpgc.miguel.fortguide.support_profile;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class SupportProfileRouter implements SupportProfileContract.Router {

    public static String TAG = SupportProfileRouter.class.getSimpleName();

    private AppMediator mediator;

    public SupportProfileRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, SupportProfileActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(SupportProfileState state) {
        mediator.setSupportProfileState(state);
    }

    @Override
    public SupportProfileState getDataFromPreviousScreen() {
        SupportProfileState state = mediator.getSupportProfileState();
        return state;
    }
}
