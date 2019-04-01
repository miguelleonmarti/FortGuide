package es.ulpgc.miguel.fortguide.challenges_detail;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;

public class ChallengesDetailModel implements ChallengesDetailContract.Model {

  public static String TAG = ChallengesDetailModel.class.getSimpleName();

  private ChallengeItem challengeItem;

  public ChallengesDetailModel() {
    challengeItem = new ChallengeItem(1, "Corrigiendo","Errores",1);
  }

  public ChallengeItem fetchData(){
    return challengeItem;
  }
}
