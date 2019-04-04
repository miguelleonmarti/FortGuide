package es.ulpgc.miguel.fortguide.data;

import java.util.List;

import es.ulpgc.miguel.fortguide.challenge.ChallengeRepository;
import es.ulpgc.miguel.fortguide.challenge.SupportRepository;

public interface RepositoryContract {


  interface FetchWeeksDataCallback {
    void onWeeksDataFetched(boolean error);
  }

  interface GetChallengeDetailListCallback{
    void  setChallengeDetailList(List<ChallengeItem> challengeItems);
  }

  interface  GetChallengeDetailCallback{
    void setChallengeDetail(ChallengeItem item);
  }

  interface GetWeeksListCallback {
    void setWeeksItemList(List<ChallengesWeeksItem> WeeksList);
  }

  interface GetWeeksItemCallback {
    void setWeeksItem(ChallengesWeeksItem challengesWeeksItem);
  }

  void loadWeeks(ChallengeRepository.FetchWeeksDataCallback callback);

  void getChallengeDetailList(
      ChallengesWeeksItem challengesWeeksItem,ChallengeRepository.GetChallengeDetailListCallback callback);

  void getChallengeDetailList(
      int weeksId, ChallengeRepository.GetChallengeDetailListCallback callback);

  void getChallengeDetails(int id, ChallengeRepository.GetChallengeDetailCallback callback);
  void getWeeksItem(int id, ChallengeRepository.GetWeeksItemCallback callback);
  void getWeeksList(ChallengeRepository.GetWeeksListCallback callback);



  interface FetchSupportDataCallback{
    void onSupportDataFetched(boolean error);
  }

  interface GetSupportListCallback{
    void setSupportList(List<SupportItem> supportList);
  }

  interface GetSupportItemCallback{
    void setSupportItem(SupportItem supportItem);
  }

  void loadSupport(SupportRepository.FetchSupportDataCallback callback);

  void getSupportList(SupportRepository.GetSupportListCallback callback);

  void getSupportItem(int id, SupportRepository.GetSupportItemCallback callback);
}