package es.ulpgc.miguel.fortguide.shop;

public class ShopModel implements ShopContract.Model {

  public static String TAG = ShopModel.class.getSimpleName();

  public ShopModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
