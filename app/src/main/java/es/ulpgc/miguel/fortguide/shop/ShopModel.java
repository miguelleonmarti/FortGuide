package es.ulpgc.miguel.fortguide.shop;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.ShopItem;

public class ShopModel implements ShopContract.Model {

  public static String TAG = ShopModel.class.getSimpleName();

  private List<ShopItem> shopItemList;
  private RepositoryContract repository;

  public ShopModel(RepositoryContract repository) {
    this.repository = repository;
    shopItemList = new ArrayList<>();
  }

  @Override
  public void fetchData(final RepositoryContract.GetShopListCallback callback) {
    // Log.e(TAG, "fetchData()");
    repository.loadShop(new RepositoryContract.FetchShopDataCallback() {
      @Override
      public void onShopDataFetched(boolean error) {
        if (!error) {
          repository.getShopList(callback);
        }
      }
    });
  }
}
