package es.ulpgc.miguel.fortguide.menu;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

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
