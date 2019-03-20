package es.ulpgc.miguel.fortguide.advice_detail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class AdviceDetailRouter implements AdviceDetailContract.Router {

    public static String TAG = AdviceDetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdviceDetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdviceDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AdviceDetailState state) {
        mediator.setAdviceDetailState(state);
    }

    @Override
    public AdviceDetailState getDataFromPreviousScreen() {
        AdviceDetailState state = mediator.getAdviceDetailState();
        return state;
    }
}
