package es.ulpgc.miguel.fortguide.challenges_detail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class ChallengesDetailRouter implements ChallengesDetailContract.Router {

    public static String TAG = ChallengesDetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public ChallengesDetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ChallengesDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ChallengesDetailState state) {
        mediator.setChallengesDetailState(state);
    }

    @Override
    public ChallengesDetailState getDataFromPreviousScreen() {
        ChallengesDetailState state = mediator.getChallengesDetailState();
        return state;
    }
}
