package es.ulpgc.miguel.fortguide.app;

import android.app.Application;

import es.ulpgc.miguel.fortguide.advice_detail.AdviceDetailState;
import es.ulpgc.miguel.fortguide.challenges_detail.ChallengesDetailListState;
import es.ulpgc.miguel.fortguide.challenges_weeks.ChallengesWeeksListState;
import es.ulpgc.miguel.fortguide.advice.AdviceState;
import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.data.TheoryItem;
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
  private ChallengesWeeksListState challengesWeeksListState;
  private ChallengesDetailListState challengesDetailState;
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
  private TheoryItem theoryItem;

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
    challengesWeeksListState = new ChallengesWeeksListState();
    adviceState = new AdviceState();
    shopState = new ShopState();
    newTheoryState = new NewTheoryState();
    supportProfileState = new SupportProfileState();
    theoryDetailState = new TheoryDetailState();
    challengesDetailState = new ChallengesDetailListState();
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

  public WeaponState getWeaponState() {
    return weaponState;
  }

  public void setWeaponState(WeaponState weaponState) {
    this.weaponState = weaponState;
  }

  public SupportState getSupportState() {
    return supportState;
  }

  public void setSupportState(SupportState supportState) {
    this.supportState = supportState;
  }

  public PlaceState getPlaceState() {
    return placeState;
  }

  public void setPlaceState(PlaceState placeState) {
    this.placeState = placeState;
  }

  public TheoryState getTheoryState() {
    return theoryState;
  }

  public void setTheoryState(TheoryState theoryState) {
    this.theoryState = theoryState;
  }

  public ChallengesWeeksListState getChallengesWeeksListState() { return challengesWeeksListState; }

  public void setChallengesWeeksListState(ChallengesWeeksListState challengesWeeksListState) { this.challengesWeeksListState = challengesWeeksListState; }

  public AdviceState getAdviceState() {
    return adviceState;
  }

  public void setAdviceState(AdviceState adviceState) {
    this.adviceState = adviceState;
  }

  public ShopState getShopState() {
    return shopState;
  }

  public void setShopState(ShopState shopState) {
    this.shopState = shopState;
  }

  public NewTheoryState getNewTheoryState() {
    return newTheoryState;
  }

  public void setNewTheoryState(NewTheoryState newTheoryState) { this.newTheoryState = newTheoryState; }

  public SupportProfileState getSupportProfileState() {
    return supportProfileState;
  }

  public void setSupportProfileState(SupportProfileState supportProfileState) { this.supportProfileState = supportProfileState; }

  public TheoryDetailState getTheoryDetailState() {
    return theoryDetailState;
  }

  public void setTheoryDetailState(TheoryDetailState theoryDetailState) { this.theoryDetailState = theoryDetailState; }

  public AdviceDetailState getAdviceDetailState() {
    return adviceDetailState;
  }

  public void setAdviceDetailState(AdviceDetailState state) {
    this.adviceDetailState = state;
  }

  public ChallengesDetailListState getChallengesDetailState() {
    return challengesDetailState;
  }

  public void setChallengesDetailState(ChallengesDetailListState challengesDetailState) { this.challengesDetailState = challengesDetailState; }

  public PlaceDetailState getPlaceDetailState() {
    return placeDetailState;
  }

  public void setPlaceDetailState(PlaceDetailState placeDetailState) { this.placeDetailState = placeDetailState;
  }

  public TheoryItem getTheoryItem() {
    return theoryItem;
  }

  public void setTheoryItem(TheoryItem theoryItem) {
    this.theoryItem = theoryItem;
  }

  //getter and setter of items

  public ChallengesWeeksItem getChallengesWeeksItem() { return challengesWeeksItem; }

  public void setChallengesWeeksItem(ChallengesWeeksItem challengesWeeksItem) {
    this.challengesWeeksItem = challengesWeeksItem;
  }

  public SupportItem getSupportItem() {
    return supportItem;
  }

  public void setSupportItem(SupportItem supportItem) {
    this.supportItem = supportItem;
  }

  public AdviceItem getAdviceItem() {
    return adviceItem;
  }

  public void setAdviceItem(AdviceItem adviceItem) {
    this.adviceItem = adviceItem;
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

  public AdviceItem getAdvice() {
    return adviceItem;
  }

  public void setAdvice(AdviceItem adviceItem) { this.adviceItem = adviceItem; }

  public TheoryItem getTheory() {
    return theoryItem;
  }

  public void setTheory(TheoryItem theoryItem) {
    this.theoryItem = theoryItem;
  }
}


