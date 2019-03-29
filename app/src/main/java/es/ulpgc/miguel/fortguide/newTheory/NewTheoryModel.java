package es.ulpgc.miguel.fortguide.newTheory;

public class NewTheoryModel implements NewTheoryContract.Model {

  public static String TAG = NewTheoryModel.class.getSimpleName();

  public NewTheoryModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
