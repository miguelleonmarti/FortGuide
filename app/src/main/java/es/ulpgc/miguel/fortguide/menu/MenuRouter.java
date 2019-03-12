package es.ulpgc.miguel.fortguide.menu;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class MenuRouter implements MenuContract.Router {

    public static String TAG = MenuRouter.class.getSimpleName();

    private AppMediator mediator;

    public MenuRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, MenuActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(MenuState state) {
        mediator.setMenuState(state);
    }

    @Override
    public MenuState getDataFromPreviousScreen() {
        MenuState state = mediator.getMenuState();
        return state;
    }
}
