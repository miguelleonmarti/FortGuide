package es.ulpgc.miguel.fortguide.menu;



public class MenuModel implements MenuContract.Model {

    public static String TAG = MenuModel.class.getSimpleName();

    public MenuModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
