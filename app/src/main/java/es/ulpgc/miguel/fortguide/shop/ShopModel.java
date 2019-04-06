package es.ulpgc.miguel.fortguide.shop;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ShopItem;

public class ShopModel implements ShopContract.Model {

  public static String TAG = ShopModel.class.getSimpleName();

  private List<ShopItem> shopItemList = new ArrayList<>();

  public ShopModel() {
  }

  @Override
  public List<ShopItem> fetchData() {
    // Log.e(TAG, "fetchData()");
    shopItemList.add(new ShopItem(1, "https://fortnite-public-files.theapinetwork.com/image/3f3bd4f-09d3bcc-4a01698-569313e.png", "Item 1", "1000"));
    shopItemList.add(new ShopItem(2, "https://fortnite-public-files.theapinetwork.com/image/e0885d2-cffa58e-dac9ac9-2d37bb1.png", "Item 2", "2000"));
    shopItemList.add(new ShopItem(3, "https://fortnite-public-files.theapinetwork.com/image/8d6862e-986cd5c-af7fb61-73cc7ec.png", "Item 3", "3000"));

    return shopItemList;
  }
}
