package es.ulpgc.miguel.fortguide.challenges_detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class ChallengesDetailModel implements ChallengesDetailContract.Model {

    public static String TAG = ChallengesDetailModel.class.getSimpleName();

    public ChallengesDetailModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
