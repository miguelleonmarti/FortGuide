package es.ulpgc.miguel.fortguide.newTheory;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.app.AppRepository;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.TheoryItem;

public interface NewTheoryContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(NewTheoryViewModel viewModel);

    void onTheoryInserted();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void startMenuScreen();

    void insertNewTheory(String user, String nameTheory, String description);

  }

  interface Model {
    void insertTheory(String user, String nameTheory, String description, RepositoryContract.InsertTheoryCallback callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(NewTheoryState state);

    NewTheoryState getDataFromPreviousScreen();

    void navigateToMenuScreen();
  }
}
