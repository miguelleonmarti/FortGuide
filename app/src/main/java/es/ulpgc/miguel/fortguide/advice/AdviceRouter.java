package es.ulpgc.miguel.fortguide.advice;

import android.content.Intent;
import android.content.Context;

public class AdviceRouter implements AdviceContract.Router {

    public static String TAG = AdviceRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdviceRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdviceActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AdviceState state) {
        mediator.setAdviceState(state);
    }

    @Override
    public AdviceState getDataFromPreviousScreen() {
        AdviceState state = mediator.getAdviceState();
        return state;
    }
}
