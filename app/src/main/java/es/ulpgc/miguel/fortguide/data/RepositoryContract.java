package es.ulpgc.miguel.fortguide.data;

import java.util.List;

import es.ulpgc.miguel.fortguide.challenge.ChallengeRepository;
import es.ulpgc.miguel.fortguide.challenge.SupportRepository;

public interface RepositoryContract {


  interface FetchChallengesWeeksDataCallback{
    void onChallengeWeeksDataFetched(boolean error);
  }

  interface GetChallengesWeeksListCallback{
    void setChallengesWeeksItemList(List<WeeksItem> challengesWeeksList);
  }

  interface GetChallengeItemCallback{
    void setChallengeItem(ChallengeItem challengeItem);
  }

  void loadChallengeWeeks(ChallengeRepository.FetchChallengesWeeksDataCallback callback);

  void getChallengesWeeksList(ChallengeRepository.GetChallengesWeeksListCallback callback);

  void getChallengeItem(int id, ChallengeRepository.GetChallengeItemCallback callback);

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