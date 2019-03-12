package es.ulpgc.miguel.fortguide.introduction;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class IntroductionRouter implements IntroductionContract.Router {

    public static String TAG = IntroductionRouter.class.getSimpleName();

    private AppMediator mediator;

    public IntroductionRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, IntroductionActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(IntroductionState state) {
        mediator.setIntroductionState(state);
    }

    @Override
    public IntroductionState getDataFromPreviousScreen() {
        IntroductionState state = mediator.getIntroductionState();
        return state;
    }
}
