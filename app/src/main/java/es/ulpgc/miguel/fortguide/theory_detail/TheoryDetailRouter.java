package es.ulpgc.miguel.fortguide.theory_detail;

import android.content.Intent;
import android.content.Context;

public class TheoryDetailRouter implements TheoryDetailContract.Router {

    public static String TAG = TheoryDetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public TheoryDetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, TheoryDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(TheoryDetailState state) {
        mediator.setTheoryDetailState(state);
    }

    @Override
    public TheoryDetailState getDataFromPreviousScreen() {
        TheoryDetailState state = mediator.getTheoryDetailState();
        return state;
    }
}
