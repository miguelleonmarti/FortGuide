package es.ulpgc.miguel.fortguide.advice_detail;

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
