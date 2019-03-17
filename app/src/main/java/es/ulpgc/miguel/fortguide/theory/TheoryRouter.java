package es.ulpgc.miguel.fortguide.theory;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.newTheory.NewTheoryActivity;

public class TheoryRouter implements TheoryContract.Router {

    public static String TAG = TheoryRouter.class.getSimpleName();

    private AppMediator mediator;

    public TheoryRouter(AppMediator mediator) {
        this.mediator = mediator;
    }


    @Override
    public void passDataToNextScreen(TheoryState state) {
        mediator.setTheoryState(state);
    }

    @Override
    public TheoryState getDataFromPreviousScreen() {
        TheoryState state = mediator.getTheoryState();
        return state;
    }

    @Override
    public void navigateToNewTheoryScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, NewTheoryActivity.class);
        context.startActivity(intent);
    }
}
