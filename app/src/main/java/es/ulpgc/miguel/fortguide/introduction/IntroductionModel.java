package es.ulpgc.miguel.fortguide.introduction;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class IntroductionModel implements IntroductionContract.Model {

    public static String TAG = IntroductionModel.class.getSimpleName();

    public IntroductionModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
