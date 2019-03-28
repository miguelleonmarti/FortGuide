package es.ulpgc.miguel.fortguide.challenges;

import android.content.Intent;
import android.content.Context;
import android.view.Menu;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

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
    public void passDataToNextScreen(ChallengeListState state) {
        mediator.setChallengeListState(state);
    }

    @Override
    public ChallengeListState getDataFromPreviousScreen() {
        ChallengeListState state = mediator.getChallengeListState();
        return state;
    }

    @Override
    public void navigateToMenuScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, MenuActivity.class);
        context.startActivity(intent);
    }
}
