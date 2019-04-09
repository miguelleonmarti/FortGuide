package es.ulpgc.miguel.fortguide.weapon_detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class WeaponDetailModel implements WeaponDetailContract.Model {

  public static String TAG = WeaponDetailModel.class.getSimpleName();

  public WeaponDetailModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
