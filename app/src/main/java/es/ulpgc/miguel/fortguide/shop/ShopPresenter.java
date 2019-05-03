package es.ulpgc.miguel.fortguide.shop;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.ShopItem;

public class ShopPresenter implements ShopContract.Presenter {

  public static String TAG = ShopPresenter.class.getSimpleName();

  private WeakReference<ShopContract.View> view;
  private ShopViewModel viewModel;
  private ShopContract.Model model;
  private ShopContract.Router router;

  public ShopPresenter(ShopState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<ShopContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ShopContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ShopContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    Log.e(TAG, "fetchData()");
    final ShopState state = router.getDataFromPreviousScreen();
    if (state.shopItemList != null) {
      viewModel.shopItemList = state.shopItemList;
      view.get().displayData(viewModel);
    } else {
      model.fetchData(new RepositoryContract.GetShopListCallback() {
        @Override
        public void setShopList(List<ShopItem> shopList) {
          viewModel.shopItemList = shopList;
          state.shopItemList = viewModel.shopItemList;
          view.get().displayData(viewModel);
        }
      });
    }
  }

  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }
}
