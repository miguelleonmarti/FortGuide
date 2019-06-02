package es.ulpgc.miguel.fortguide.data;

import java.util.List;
import es.ulpgc.miguel.fortguide.app.AppRepository;

public interface RepositoryContract {

  // callback and methods of Menu

  /**
   * Callback that is called when we download  all the information  about server status from the JSON
   */
  interface FetchServerStatusCallback {
    void onServerStatusFetch(boolean error);
  }

  /**
   * Callback that is called after the information was download about the server status
   */
  interface GetServerStatusCallback {
    void setStatus(boolean status);
  }

  /**
   * @param callback needed because of async method
   */
  void loadServerStatus(RepositoryContract.FetchServerStatusCallback callback);

  /**
   * @param callback needed because of async method
   */
  void getServerStatus(RepositoryContract.GetServerStatusCallback callback);

  // callbacks and methods of Support

  /**
   * Callback that is called when we download  all the information  about support data from the JSON
   */
  interface FetchSupportDataCallback {
    void onSupportDataFetched(boolean error);
  }

  /**
   * Callback that is called after the information was download about the List of support
   */
  interface GetSupportListCallback {
    void setSupportList(List<SupportItem> supportList);
  }

  /**
   * Callback that is called after the information was download about the item of support
   */
  interface GetSupportItemCallback {
    void setSupportItem(SupportItem supportItem);
  }

  /**
   * @param callback needed because of async method
   */
  void loadSupport(final boolean clearFirst, AppRepository.FetchSupportDataCallback callback);

  /**
   * @param callback needed because of async method
   */
  void getSupportList(AppRepository.GetSupportListCallback callback);


  // callbacks and methods of Weapon

  /**
   * Callback that is called when we download  all the information  about weapon data from the JSON
   */
  interface FetchWeaponDataCallback {
    void onWeaponDataFetched(boolean error);
  }

  /**
   * Callback that is called after the information was download about the list of weapon
   */
  interface GetWeaponListCallback {
    void setWeaponList(List<WeaponItem> weaponList);
  }

  /**
   * @param callback needed because of async method
   */
  void loadWeapon(final boolean clearFirst, AppRepository.FetchWeaponDataCallback callback);

  /**
   * @param callback needed because of async method
   */
  void getWeaponList(String rarity, AppRepository.GetWeaponListCallback callback);

  // callbacks and methods of Challenge

  /**
   * Callback that is called when we download  all the information  about weeks data from the JSON
   */
  interface FetchWeeksDataCallback {
    void onWeeksDataFetched(boolean error);
  }

  /**
   * Callback that is called when we download  all the information  about challenges data from the JSON
   */
  interface FetchChallengesDataCallback {
    void onChallengesDataFetched(boolean error);
  }

  /**
   * Callback that is called after the information was download about the list of challenge
   */
  interface GetChallengeDetailListCallback {
    void setChallengeDetailList(List<ChallengeItem> challengeItems);
  }

  /**
   * Callback that is called after the information was download about the item of challenge
   */
  interface GetChallengeDetailCallback {
    void setChallengeDetail(ChallengeItem item);
  }

  /**
   * Callback that is called after the information was download about the list of weeks
   */
  interface GetWeeksListCallback {
    void setWeeksItemList(List<ChallengesWeeksItem> WeeksList);
  }

  /**
   * Callback that is called after the information was download about the item of weeks
   */
  interface GetWeeksItemCallback {
    void setWeeksItem(ChallengesWeeksItem challengesWeeksItem);
  }

  /**
   * @param callback needed because of async method
   */
  void loadWeeks(final boolean clearFirst, AppRepository.FetchWeeksDataCallback callback);

  /**
   * @param weekId in order to do more efficient searches
   * @return the list of challenges
   */
  void loadChallenges(final boolean clearFirst, final int weekId, AppRepository.FetchChallengesDataCallback callback);

  /**
   * @param challengesWeeksItem challenges of a week
   * @param callback            needed because of async method
   */
  void getChallengeDetailList(ChallengesWeeksItem challengesWeeksItem, AppRepository.GetChallengeDetailListCallback callback);

  /**
   * @param weeksId  in order to do more efficient searches
   * @param callback needed because of async method
   */
  void getChallengeDetailList(int weeksId, AppRepository.GetChallengeDetailListCallback callback);

  /**
   * @param id       in order to do more efficient searches
   * @param callback needed because of async method
   */
  void getChallengeDetails(int id, AppRepository.GetChallengeDetailCallback callback);

  /**
   * @param id       in order to do more efficient searches
   * @param callback needed because of async method
   */
  void getWeeksItem(int id, AppRepository.GetWeeksItemCallback callback);

  /**
   * @param callback needed because of async method
   */
  void getWeeksList(AppRepository.GetWeeksListCallback callback);

  // callbacks and methods of Place

  /**
   * Callback that is called when we download  all the information  about place data from the JSON
   */
  interface FetchPlaceDataCallback {
    void onPlaceDataFetched(boolean error);
  }

  /**
   * Callback that is called after the information was download about the list of place
   */
  interface GetPlaceListCallback {
    void setPlaceList(List<PlaceItem> placeList);
  }

  /**
   * Callback that is called after the information was download about the item of place
   */
  interface GetPlaceItemCallback {
    void setPlaceItem(PlaceItem placeItem);
  }

  /**
   * @param callback needed because of async method
   */
  void loadPlace(final boolean clearFirst, AppRepository.FetchPlaceDataCallback callback);

  /**
   * @param callback needed because of async method
   */
  void getPlaceList(AppRepository.GetPlaceListCallback callback);

  /**
   * @param id       because is the primary key of a challengesWeeksItem
   * @param callback needed because of async method
   */
  void getPlaceItem(int id, AppRepository.GetPlaceItemCallback callback);

  // callbacks and methods of Advice

  /**
   * Callback that is called when we download  all the information  about advice data from the JSON
   */
  interface FetchAdviceDataCallback{
    void onAdviceDataFetched(boolean error);
  }

  /**
   * Callback that is called after the information was download about the List of advice
   */
  interface GetAdviceListCallback{
    void setAdviceList(List<AdviceItem> adviceList);
  }

  /**
   * Callback that is called after the information was download about the item of advice
   */
  interface GetAdviceItemCallback{
    void setAdviceItem(AdviceItem adviceItem);
  }

  /**
   * @param callback needed because of async method
   */
  void loadAdvice (final boolean clearFirst, AppRepository.FetchAdviceDataCallback callback);

  /**
   * @param callback needed because of async method
   */
  void getAdviceList(AppRepository.GetAdviceListCallback callback);

  // callbacks and methods of Shop

  /**
   * Callback that is called when we download  all the information  about shop data from the JSON
   */
  interface FetchShopDataCallback {
    void onShopDataFetched(boolean error);
  }

  /**
   * Callback that is called after the information was download about the List of shop
   */
  interface GetShopListCallback{
    void setShopList(List<ShopItem> shopList);
  }
  /**
   * Callback that is called after the information was download about the item of shop
   */
  interface GetShopItemCallback{
    void setShopItem(ShopItem shopItem);
  }

  /**
   * @param callback needed because of async method
   */
  void loadShop(final boolean clearFirst, AppRepository.FetchShopDataCallback callback);

  /**
   * @param callback needed because of async method
   */
  void getShopList(AppRepository.GetShopListCallback callback);

  /**
   * @param id       because is the primary key of a shopItem
   * @param callback needed because of async method
   */
  void getShopItem(int id, AppRepository.GetShopItemCallback callback);

  // callbacks and methods of Theory

  /**
   * Callback that is called when we download  all the information  about theory data from the JSON
   */
  interface FetchTheoryDataCallback{
    void onTheoryDataFetched(boolean error);
  }

  /**
   * Callback that is called after the information was download about the List of theory
   */
  interface GetTheoryListCallback{
    void setTheoryList(List<TheoryItem> theoryList);
  }

  /**
   * A methods that insert new Theories.
   */
  interface InsertTheoryCallback{
    void theoryInserted();
  }

  /**
   * Callback that is called after the information was download about the item of theory
   */
  interface GetTheoryItemCallback{
    void setTheoryItem(TheoryItem theoryItem);
  }

  /**
   * @param callback needed because of async method
   */
  void loadTheory (final boolean clearFirst, AppRepository.FetchTheoryDataCallback callback);

  /**
   * @param callback needed because of async method
   */
  void getTheoryList(AppRepository.GetTheoryListCallback callback);

  /**
   * @param id The id of the theory item
   * @param callback needed because of async method
   */
  void getTheoryItem(int id, AppRepository.GetTheoryItemCallback callback);

  /**
   * @param user The name of the person that think this theory
   * @param nameTheory The name of the Theory
   * @param description The information about the Theory
   * @param callback needed because of async method
   */
  void insertTheory(String user, String nameTheory, String description, AppRepository.InsertTheoryCallback callback);
}