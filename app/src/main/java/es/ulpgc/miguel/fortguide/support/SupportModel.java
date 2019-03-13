package es.ulpgc.miguel.fortguide.support;

public class SupportModel implements SupportContract.Model {

    public static String TAG = SupportModel.class.getSimpleName();

    public SupportModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
