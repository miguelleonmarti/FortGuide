package es.ulpgc.miguel.fortguide.advice_detail;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.lang.ref.WeakReference;



public class AdviceDetailModel implements AdviceDetailContract.Model {

  public static String TAG = AdviceDetailModel.class.getSimpleName();

  public AdviceDetailModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
