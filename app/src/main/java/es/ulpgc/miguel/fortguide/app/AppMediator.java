package es.ulpgc.miguel.fortguide.app;

import android.app.Application;

import es.ulpgc.miguel.fortguide.advice_detail.AdviceDetailState;
import es.ulpgc.miguel.fortguide.challenges_detail.ChallengesDetailState;
import es.ulpgc.miguel.fortguide.challenges_weeks.WeeksListState;
import es.ulpgc.miguel.fortguide.advice.AdviceState;
import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.introduction.IntroductionState;
import es.ulpgc.miguel.fortguide.menu.MenuState;
import es.ulpgc.miguel.fortguide.newTheory.NewTheoryState;
import es.ulpgc.miguel.fortguide.place.PlaceState;
import es.ulpgc.miguel.fortguide.place_detail.PlaceDetailState;
import es.ulpgc.miguel.fortguide.shop.ShopState;
import es.ulpgc.miguel.fortguide.support.SupportState;
import es.ulpgc.miguel.fortguide.support_profile.SupportProfileState;
import es.ulpgc.miguel.fortguide.theory.TheoryState;
import es.ulpgc.miguel.fortguide.theory_detail.TheoryDetailState;
import es.ulpgc.miguel.fortguide.weapon.WeaponState;

public class AppMediator extends Application {

  // declaring states
  private IntroductionState introductionState;
  private MenuState menuState;
  private PlaceState placeState;
  private SupportState supportState;
  private WeaponState weaponState;
  private TheoryState theoryState;
  private WeeksListState weeksListState;
  private ChallengesDetailState challengesDetailState;
  private AdviceState adviceState;
  private ShopState shopState;
  private NewTheoryState newTheoryState;
  private SupportProfileState supportProfileState;
  private TheoryDetailState theoryDetailState;
  private AdviceDetailState adviceDetailState;
  private PlaceDetailState placeDetailState;

  //declaring items
  private SupportItem supportItem;
  private ChallengesWeeksItem challengesWeeksItem;
  private ChallengeItem challengeItem;
  private PlaceItem placeItem;
  private AdviceItem adviceItem;

  @Override
  public void onCreate() {
    super.onCreate();

    introductionState = new IntroductionState();
    menuState = new MenuState();
    placeState = new PlaceState();
    placeDetailState = new PlaceDetailState();
    supportState = new SupportState();
    weaponState = new WeaponState();
    theoryState = new TheoryState();
    weeksListState = new WeeksListState();
    adviceState = new AdviceState();
    shopState = new ShopState();
    newTheoryState = new NewTheoryState();
    supportProfileState = new SupportProfileState();
    theoryDetailState = new TheoryDetailState();
    challengesDetailState = new ChallengesDetailState();
    adviceDetailState = new AdviceDetailState();
  }

  // getters and setters of states

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

  public void setChallengesWeeksListState(WeeksListState weeksListState) {
    this.weeksListState = weeksListState;
  }

  public WeeksListState getWeeksListState() {
    return weeksListState;
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
    this.newTheoryState = newTheoryState;
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

  public void setTheoryDetailState(TheoryDetailState theoryDetailState) {
    this.theoryDetailState = theoryDetailState;
  }

  public TheoryDetailState getTheoryDetailState() {
    return theoryDetailState;
  }

  public AdviceDetailState getAdviceDetailState() {
    return adviceDetailState;
  }

  public void setAdviceDetailState(AdviceDetailState state) {
    this.adviceDetailState = state;
  }

  public void setSupportItem(SupportItem supportItem) {
    this.supportItem = supportItem;
  }

  public SupportItem getSupportItem() {
    return supportItem;
  }

  public ChallengesDetailState getChallengesDetailState() {
    return challengesDetailState;
  }

  public void setChallengesDetailState(ChallengesDetailState challengesDetailState) {
    this.challengesDetailState = challengesDetailState;
  }

  public ChallengesWeeksItem getChallengesWeeksItem() {
    ChallengesWeeksItem item = challengesWeeksItem;
    return item;
  }

  public void setChallengesWeeksItem(ChallengesWeeksItem challengesWeeksItem) {
    this.challengesWeeksItem = challengesWeeksItem;
  }

  public ChallengeItem getChallengeItem() {
    return challengeItem;
  }

  public void setChallengeItem(ChallengeItem challengeItem) {
    this.challengeItem = challengeItem;
  }

  public PlaceItem getPlaceItem() {
    return placeItem;
  }

  public void setPlaceItem(PlaceItem placeItem) {
    this.placeItem = placeItem;
  }

  public void setPlaceDetailState(PlaceDetailState placeDetailState) {
    this.placeDetailState = placeDetailState;
  }

  public PlaceDetailState getPlaceDetailState() {
    return placeDetailState;
  }

  public AdviceItem getAdvice() {
    return adviceItem;
  }

  public void setAdvice(AdviceItem adviceItem) {
    this.adviceItem = adviceItem;

  }

}


