package es.ulpgc.miguel.fortguide.app;

import android.app.Application;

public class AppMediator extends Application {

    private MenuState menuState;

    @Override
    public void onCreate() {
        super.onCreate();

        menuState = new MenuState();
    }
}
