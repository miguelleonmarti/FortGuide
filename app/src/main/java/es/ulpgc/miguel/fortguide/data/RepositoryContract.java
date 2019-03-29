package es.ulpgc.miguel.fortguide.data;

import java.util.List;

import es.ulpgc.miguel.fortguide.challenge.SupportRepository;

public interface RepositoryContract {
  List<ChallengesWeeksItem> getChallengeList();

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