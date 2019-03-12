package es.ulpgc.miguel.fortguide.app;

import android.app.Application;

import es.ulpgc.miguel.fortguide.menu.MenuState;

public class AppMediator extends Application {

    private MenuState menuState;

    @Override
    public void onCreate() {
        super.onCreate();

        menuState = new MenuState();
    }
}
