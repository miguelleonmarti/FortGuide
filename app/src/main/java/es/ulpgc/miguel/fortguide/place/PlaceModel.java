package es.ulpgc.miguel.fortguide.place;

public class PlaceModel implements PlaceContract.Model {

    public static String TAG = PlaceModel.class.getSimpleName();

    public PlaceModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
