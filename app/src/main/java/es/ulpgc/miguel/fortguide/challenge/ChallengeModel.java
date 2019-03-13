package es.ulpgc.miguel.fortguide.challenge;

public class ChallengeModel implements ChallengeContract.Model {

    public static String TAG = ChallengeModel.class.getSimpleName();

    public ChallengeModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
