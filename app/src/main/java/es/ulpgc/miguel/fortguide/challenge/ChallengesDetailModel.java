package es.ulpgc.miguel.fortguide.challenge;

public class ChallengesDetailModel implements ChallengesDetailContract.Model {

  public static String TAG = ChallengesDetailModel.class.getSimpleName();

  public ChallengesDetailModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
