package es.ulpgc.miguel.fortguide.challenges;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class ChallengeListRouter implements ChallengeListContract.Router {

    public static String TAG = ChallengeListRouter.class.getSimpleName();

    private AppMediator mediator;

    public ChallengeListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ChallengeListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ChallengeListListState state) {
        mediator.setChallengeListState(state);
    }

    @Override
    public ChallengeListListState getDataFromPreviousScreen() {
        ChallengeListListState state = mediator.getChallengeListState();
        return state;
    }
}
