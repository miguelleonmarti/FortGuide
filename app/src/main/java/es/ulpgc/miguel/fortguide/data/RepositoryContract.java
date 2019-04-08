package es.ulpgc.miguel.fortguide.data;

import java.util.List;
import es.ulpgc.miguel.fortguide.challenge.AppRepository;

public interface RepositoryContract {

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

  void loadSupport(AppRepository.FetchSupportDataCallback callback);

  void getSupportList(AppRepository.GetSupportListCallback callback);

  void getSupportItem(int id, AppRepository.GetSupportItemCallback callback);


  // callbacks and methods of Challenge

  interface FetchWeeksDataCallback {
    void onWeeksDataFetched(boolean error);
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

  void loadWeeks(AppRepository.FetchWeeksDataCallback callback);

  void getChallengeDetailList(ChallengesWeeksItem challengesWeeksItem, AppRepository.GetChallengeDetailListCallback callback);

  void getChallengeDetailList(int weeksId, AppRepository.GetChallengeDetailListCallback callback);

  void getChallengeDetails(int id, AppRepository.GetChallengeDetailCallback callback);

  void getWeeksItem(int id, AppRepository.GetWeeksItemCallback callback);

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

  void loadPlace(AppRepository.FetchPlaceDataCallback callback);

  void getPlaceList(AppRepository.GetPlaceListCallback callback);

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

  void loadAdvice (AppRepository.FetchAdviceDataCallback callback);

  void getAdviceList(AppRepository.GetAdviceListCallback callback);

  void getAdviceItem(int id, AppRepository.GetAdviceItemCallback callback);

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

  void loadShop(AppRepository.FetchShopDataCallback callback);

  void getShopList(AppRepository.GetShopListCallback callback);

  void getShopItem(int id, AppRepository.GetShopItemCallback callback);

}