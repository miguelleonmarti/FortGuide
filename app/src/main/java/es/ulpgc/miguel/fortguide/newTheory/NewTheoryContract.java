package es.ulpgc.miguel.fortguide.newTheory;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.app.AppRepository;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.TheoryItem;

public interface NewTheoryContract {

  interface View {
    /**
     * Dependency injection
     * @param presenter Presenter
     */
    void injectPresenter(Presenter presenter);

    /**
     * Display the data that has been fetch on the UI
     * @param viewModel ViewModel
     */
    void displayData(NewTheoryViewModel viewModel);

    void onTheoryInserted();
  }

  interface Presenter {
    /**
     * Dependency injection
     * @param view View
     */
    void injectView(WeakReference<View> view);

    /**
     * Dependency injection
     * @param model Model
     */
    void injectModel(Model model);

    /**
     * Dependency injection
     * @param router Router
     */
    void injectRouter(Router router);

    /**
     * Fetch data (the item) when it is required
     * It is an async task
     */
    void fetchData();

    /**
     * Going to the menu screen when the bananaButton is pressed
     */
    void startMenuScreen();

    /**
     * Passing the written fields in the screen to the model in order to insert them in the
     * database
     * @param user String
     * @param nameTheory String
     * @param description String
     */
    void insertNewTheory(String user, String nameTheory, String description);

  }

  interface Model {
    /**
     * Passing the fields to the AppRepository in order to insert them in the database in form of a TheoryItem
     * It is an async task
     * @param user String
     * @param nameTheory String
     * @param description String
     * @param callback callback
     */
    void insertTheory(String user, String nameTheory, String description, RepositoryContract.InsertTheoryCallback callback);
  }

  interface Router {
    /**
     * Used to pass the state to the mediator in order to save it
     * @param state NewTheoryState
     */
    void passDataToNextScreen(NewTheoryState state);

    /**
     * Recovering the advice state (it has the list)
     * in case the fetch data has been done before
     * @return NewTheoryState
     */
    NewTheoryState getDataFromPreviousScreen();

    /**
     * Intent to the menu screen
     */
    void navigateToMenuScreen();
  }
}
