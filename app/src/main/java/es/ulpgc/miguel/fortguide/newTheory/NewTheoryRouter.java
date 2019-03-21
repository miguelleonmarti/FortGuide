package es.ulpgc.miguel.fortguide.newTheory;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.menu.MenuActivity;

public class NewTheoryRouter implements NewTheoryContract.Router {

    public static String TAG = NewTheoryRouter.class.getSimpleName();

    private AppMediator mediator;

    public NewTheoryRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, NewTheoryActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(NewTheoryState state) {
        mediator.setNewTheoryState(state);
    }

    @Override
    public NewTheoryState getDataFromPreviousScreen() {
        NewTheoryState state = mediator.getNewTheoryState();
        return state;
    }

    @Override
    public void navigateToMenuScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, MenuActivity.class);
        context.startActivity(intent);
    }
}
