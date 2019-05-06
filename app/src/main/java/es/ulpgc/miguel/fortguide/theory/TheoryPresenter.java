package es.ulpgc.miguel.fortguide.theory;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;


import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.TheoryItem;

public class TheoryPresenter implements TheoryContract.Presenter {

  public static String TAG = TheoryPresenter.class.getSimpleName();

  private WeakReference<TheoryContract.View> view;
  private TheoryViewModel viewModel;
  private TheoryContract.Model model;
  private TheoryContract.Router router;

  public TheoryPresenter(TheoryState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<TheoryContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(TheoryContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(TheoryContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    //Log.e(TAG, "fetchData()");
    TheoryState state = router.getDataFromPreviousScreen();
    if (state.theoryItemList != null) {
      viewModel.theoryItemList = state.theoryItemList;
      view.get().displayData(viewModel);
    } else {
      model.fetchTheoryListData(new RepositoryContract.GetTheoryListCallback(){
        @Override
        public void setTheoryList(List<TheoryItem> theoryList) {
          viewModel.theoryItemList = theoryList;
          view.get().displayData(viewModel);
        }
      });
    }
  }

  @Override
  public void selectTheoryListData(TheoryItem item){
    router.passDataToTheoryDetailScreen(item);
    router.navigateToTheoryDetailScreen();
  }

  @Override
  public void startNewTheoryScreen() {
    router.navigateToNewTheoryScreen();
  }

  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }
}
