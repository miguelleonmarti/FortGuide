package es.ulpgc.miguel.fortguide.theory;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.TheoryItem;

public interface TheoryContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(TheoryViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void startNewTheoryScreen();

    void startMenuScreen();

    void selectTheoryListData(TheoryItem item);
  }

  interface Model {
    void fetchTheoryListData(final RepositoryContract.GetTheoryListCallback callback);
  }

  interface Router {

    void passDataToTheoryDetailScreen(TheoryItem item);

    TheoryState getDataFromPreviousScreen();

    void navigateToNewTheoryScreen();

    void navigateToTheoryDetailScreen();

    void navigateToMenuScreen();
  }
}
