package es.ulpgc.miguel.fortguide.support_profile;

public class SupportProfileModel implements SupportProfileContract.Model {

    public static String TAG = SupportProfileModel.class.getSimpleName();

    public SupportProfileModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
