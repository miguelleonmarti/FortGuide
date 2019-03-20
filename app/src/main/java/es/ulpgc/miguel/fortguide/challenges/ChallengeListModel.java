package es.ulpgc.miguel.fortguide.challenges;

public class ChallengeListModel implements ChallengeListContract.Model {

    public static String TAG = ChallengeListModel.class.getSimpleName();

    public ChallengeListModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
