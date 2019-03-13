package es.ulpgc.miguel.fortguide.challenge;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class ChallengeRouter implements ChallengeContract.Router {

    public static String TAG = ChallengeRouter.class.getSimpleName();

    private AppMediator mediator;

    public ChallengeRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ChallengeActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ChallengeState state) {
        mediator.setChallengeState(state);
    }

    @Override
    public ChallengeState getDataFromPreviousScreen() {
        ChallengeState state = mediator.getChallengeState();
        return state;
    }
}
