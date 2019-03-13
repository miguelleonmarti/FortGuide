package es.ulpgc.miguel.fortguide.advice;

public class AdviceModel implements AdviceContract.Model {

    public static String TAG = AdviceModel.class.getSimpleName();

    public AdviceModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
