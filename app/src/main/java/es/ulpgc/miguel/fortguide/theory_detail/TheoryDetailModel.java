package es.ulpgc.miguel.fortguide.theory_detail;

public class TheoryDetailModel implements TheoryDetailContract.Model {

    public static String TAG = TheoryDetailModel.class.getSimpleName();

    public TheoryDetailModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
