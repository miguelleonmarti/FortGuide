package es.ulpgc.miguel.fortguide.weapon;

import android.content.Intent;
import android.content.Context;

public class WeaponRouter implements WeaponContract.Router {

    public static String TAG = WeaponRouter.class.getSimpleName();

    private AppMediator mediator;

    public WeaponRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, WeaponActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(WeaponState state) {
        mediator.setWeaponState(state);
    }

    @Override
    public WeaponState getDataFromPreviousScreen() {
        WeaponState state = mediator.getWeaponState();
        return state;
    }
}
