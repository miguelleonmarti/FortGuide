package es.ulpgc.miguel.fortguide.weapon;

public class WeaponModel implements WeaponContract.Model {

  public static String TAG = WeaponModel.class.getSimpleName();

  public WeaponModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "";
  }
}
