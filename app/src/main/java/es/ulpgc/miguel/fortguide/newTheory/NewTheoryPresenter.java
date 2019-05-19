package es.ulpgc.miguel.fortguide.newTheory;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.app.AppRepository;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class NewTheoryPresenter implements NewTheoryContract.Presenter {

  public static String TAG = NewTheoryPresenter.class.getSimpleName();

  private WeakReference<NewTheoryContract.View> view;
  private NewTheoryViewModel viewModel;
  private NewTheoryContract.Model model;
  private NewTheoryContract.Router router;

  public NewTheoryPresenter(NewTheoryState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<NewTheoryContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(NewTheoryContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(NewTheoryContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    NewTheoryState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      //String data = model.fetchData();

      // set initial state
      //viewModel.data = data;
    }

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void startMenuScreen() {
    router.navigateToMenuScreen();
  }

  @Override
  public void insertNewTheory(String user, String nameTheory, String description) {
    model.insertTheory(user, nameTheory, description, new RepositoryContract.InsertTheoryCallback() {
      @Override
      public void theoryInserted() {
        view.get().onTheoryInserted();
      }
    });
  }


}
