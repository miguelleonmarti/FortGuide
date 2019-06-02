package es.ulpgc.miguel.fortguide.data;

import java.util.List;
import es.ulpgc.miguel.fortguide.app.AppRepository;

public interface RepositoryContract {

  // callback and methods of Menu

  interface FetchServerStatusCallback {
    void onServerStatusFetch(boolean error);
  }

  interface GetServerStatusCallback {
    void setStatus(boolean status);
  }

  void loadServerStatus(RepositoryContract.FetchServerStatusCallback callback);

  void getServerStatus(RepositoryContract.GetServerStatusCallback callback);

  // callbacks and methods of Support

  interface FetchSupportDataCallback {
    void onSupportDataFetched(boolean error);
  }

  interface GetSupportListCallback {
    void setSupportList(List<SupportItem> supportList);
  }

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

  interface FetchWeaponDataCallback {
    void onWeaponDataFetched(boolean error);
  }

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

  interface FetchWeeksDataCallback {
    void onWeeksDataFetched(boolean error);
  }

  interface FetchChallengesDataCallback {
    void onChallengesDataFetched(boolean error);
  }

  interface GetChallengeDetailListCallback {
    void setChallengeDetailList(List<ChallengeItem> challengeItems);
  }

  interface GetChallengeDetailCallback {
    void setChallengeDetail(ChallengeItem item);
  }

  interface GetWeeksListCallback {
    void setWeeksItemList(List<ChallengesWeeksItem> WeeksList);
  }

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

  interface FetchPlaceDataCallback {
    void onPlaceDataFetched(boolean error);
  }

  interface GetPlaceListCallback {
    void setPlaceList(List<PlaceItem> placeList);
  }

  interface GetPlaceItemCallback {
    void setPlaceItem(SupportItem supportItem);
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

  interface FetchAdviceDataCallback{
    void onAdviceDataFetched(boolean error);
  }

  interface GetAdviceListCallback{
    void setAdviceList(List<AdviceItem> adviceList);
  }

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

  interface FetchShopDataCallback {
    void onShopDataFetched(boolean error);
  }

  interface GetShopListCallback{
    void setShopList(List<ShopItem> shopList);
  }

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

  interface FetchTheoryDataCallback{
    void onTheoryDataFetched(boolean error);
  }

  interface GetTheoryListCallback{
    void setTheoryList(List<TheoryItem> theoryList);
  }

  interface InsertTheoryCallback{
    void theoryInserted();
  }

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

  void getTheoryItem(int id, AppRepository.GetTheoryItemCallback callback);

  void insertTheory(String user, String nameTheory, String description, AppRepository.InsertTheoryCallback callback);
}