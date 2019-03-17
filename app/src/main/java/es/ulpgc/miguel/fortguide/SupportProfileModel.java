package es.ulpgc.miguel.fortguide;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

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
