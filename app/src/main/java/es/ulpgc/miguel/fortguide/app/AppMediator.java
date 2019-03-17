package es.ulpgc.miguel.fortguide.app;

import android.app.Application;

import es.ulpgc.miguel.fortguide.SupportProfileState;
import es.ulpgc.miguel.fortguide.advice.AdviceState;
import es.ulpgc.miguel.fortguide.challenge.ChallengeState;
import es.ulpgc.miguel.fortguide.introduction.IntroductionState;
import es.ulpgc.miguel.fortguide.menu.MenuState;
import es.ulpgc.miguel.fortguide.newTheory.NewTheoryState;
import es.ulpgc.miguel.fortguide.place.PlaceState;
import es.ulpgc.miguel.fortguide.shop.ShopState;
import es.ulpgc.miguel.fortguide.support.SupportState;
import es.ulpgc.miguel.fortguide.theory.TheoryState;
import es.ulpgc.miguel.fortguide.weapon.WeaponState;

public class AppMediator extends Application {

  private IntroductionState introductionState;
  private MenuState menuState;
  private PlaceState placeState;
  private SupportState supportState;
  private WeaponState weaponState;
  private TheoryState theoryState;
  private ChallengeState challengeState;
  private AdviceState adviceState;
  private ShopState shopState;
  private NewTheoryState newTheoryState;
  private SupportProfileState supportProfileState;

    @Override
  public void onCreate() {
    super.onCreate();

    introductionState = new IntroductionState();
    menuState = new MenuState();
    placeState = new PlaceState();
    supportState = new SupportState();
    weaponState = new WeaponState();
    theoryState = new TheoryState();
    challengeState = new ChallengeState();
    adviceState = new AdviceState();
    shopState = new ShopState();
    newTheoryState = new NewTheoryState();
    supportProfileState = new SupportProfileState();
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

  public void setWeaponState(WeaponState weaponState) {
        this.weaponState = weaponState;
    }

  public WeaponState getWeaponState() {
        return weaponState;
    }

  public void setSupportState(SupportState supportState) {
        this.supportState = supportState;
    }

  public SupportState getSupportState() {
        return supportState;
    }

  public void setPlaceState(PlaceState placeState) {
        this.placeState = placeState;
    }

  public PlaceState getPlaceState() {
        return placeState;
    }

  public void setTheoryState(TheoryState theoryState) {
        this.theoryState = theoryState;
    }

  public TheoryState getTheoryState() {
        return theoryState;
    }

  public void setChallengeState(ChallengeState challengeState) {
        this.challengeState = challengeState;
    }

  public ChallengeState getChallengeState() {
        return challengeState;
    }

  public void setAdviceState(AdviceState adviceState) {
        this.adviceState = adviceState;
    }

  public AdviceState getAdviceState() {
        return adviceState;
    }

  public ShopState getShopState() {
      return shopState;
    }

  public void setShopState(ShopState shopState) {
      this.shopState = shopState;
    }

  public void setNewTheoryState(NewTheoryState newTheoryState) {
        this.newTheoryState=newTheoryState;
    }

  public NewTheoryState getNewTheoryState() {
        return newTheoryState;
    }

  public void setSupportProfileState(SupportProfileState supportProfileState) {
        this.supportProfileState = supportProfileState;
    }

  public SupportProfileState getSupportProfileState() {
        return supportProfileState;
    }
}
