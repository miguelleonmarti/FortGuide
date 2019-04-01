package es.ulpgc.miguel.fortguide.data;

import java.util.List;

import es.ulpgc.miguel.fortguide.challenge.ChallengeRepository;
import es.ulpgc.miguel.fortguide.challenge.SupportRepository;

public interface RepositoryContract {


  interface FetchWeeksDataCallback {
    void onWeeksDataFetched(boolean error);
  }

  interface GetWeeksListCallback {
    void setWeeksItemList(List<WeeksItem> WeeksList);
  }

  interface GetWeeksItemCallback {
    void setWeeksItem(WeeksItem weeksItem);
  }

  void loadWeeks(ChallengeRepository.FetchWeeksDataCallback callback);

  void getWeeksList(ChallengeRepository.GetWeeksListCallback callback);

  void getWeeksItem(int id, ChallengeRepository.GetWeeksItemCallback callback);

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