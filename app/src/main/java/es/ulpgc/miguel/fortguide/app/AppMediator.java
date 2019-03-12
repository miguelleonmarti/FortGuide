package es.ulpgc.miguel.fortguide.app;

import android.app.Application;

import es.ulpgc.miguel.fortguide.introduction.IntroductionState;
import es.ulpgc.miguel.fortguide.menu.MenuState;

public class AppMediator extends Application {

    private IntroductionState introductionState;
    private MenuState menuState;

    @Override
    public void onCreate() {
        super.onCreate();

        introductionState = new IntroductionState();
        menuState = new MenuState();
    }

    public IntroductionState getIntroductionState() {
        return introductionState;
    }

    public void setIntroductionState(IntroductionState introductionState) {
        this.introductionState = introductionState;
    }

    public MenuState getMenuState() {
        return menuState;
    }

    public void setMenuState(MenuState menuState) {
        this.menuState = menuState;
    }
}
