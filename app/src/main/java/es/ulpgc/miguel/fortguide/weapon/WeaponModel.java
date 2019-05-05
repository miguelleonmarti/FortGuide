package es.ulpgc.miguel.fortguide.weapon;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.ShopItem;

public class WeaponModel implements WeaponContract.Model {

  public static String TAG = WeaponModel.class.getSimpleName();

  private List<ShopItem> shopItemList;
  private RepositoryContract repository;

  public WeaponModel(RepositoryContract repository) {
    this.repository = repository;
    shopItemList = new ArrayList<>();
  }

  @Override
  public void fetchData(final RepositoryContract.GetWeaponListCallback callback) {
    repository.loadWeapon(true, new RepositoryContract.FetchWeaponDataCallback() {
      @Override
      public void onWeaponDataFetched(boolean error) {
        if (!error) {
          repository.getWeaponList(callback);
        }
      }
    });
  }
}
