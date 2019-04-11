package es.ulpgc.miguel.fortguide.weapon_detail;


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
