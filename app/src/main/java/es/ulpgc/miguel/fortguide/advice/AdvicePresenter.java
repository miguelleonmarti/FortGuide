package es.ulpgc.miguel.fortguide.advice;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class AdvicePresenter implements AdviceContract.Presenter {

  public static String TAG = AdvicePresenter.class.getSimpleName();

  private WeakReference<AdviceContract.View> view;
  private AdviceViewModel viewModel;
  private AdviceContract.Model model;
  private AdviceContract.Router router;

  public AdvicePresenter(AdviceState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AdviceContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AdviceContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AdviceContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    //Log.e(TAG, "fetchData()");
    final AdviceState state = router.getDataFromPreviousScreen();
    if (state.adviceItemList != null) {
      viewModel.adviceItemList = state.adviceItemList;
      view.get().displayData(viewModel);
    } else {
      model.fetchAdviceListData(new RepositoryContract.GetAdviceListCallback(){
        @Override
        public void setAdviceList(List<AdviceItem> adviceList) {
          viewModel.adviceItemList = adviceList;
          state.adviceItemList = viewModel.adviceItemList;
          view.get().displayData(viewModel);
        }
      });
    }
  }

  @Override
  public void selectAdviceListData(AdviceItem item){
    router.passDataToAdviceDetailScreen(item);
    router.navigateToAdviceDetailScreen();
  }


  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }
}
