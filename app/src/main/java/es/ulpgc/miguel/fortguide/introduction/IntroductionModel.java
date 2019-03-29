package es.ulpgc.miguel.fortguide.introduction;


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
