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

}