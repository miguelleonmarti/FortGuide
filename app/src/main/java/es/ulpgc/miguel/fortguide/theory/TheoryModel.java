package es.ulpgc.miguel.fortguide.theory;

public class TheoryModel implements TheoryContract.Model {

    public static String TAG = TheoryModel.class.getSimpleName();

    public TheoryModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
