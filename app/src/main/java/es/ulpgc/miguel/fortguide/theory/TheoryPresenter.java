package es.ulpgc.miguel.fortguide.theory;

import java.lang.ref.WeakReference;

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
        // Log.e(TAG, "fetchData()");

        // set passed state
        TheoryState state = router.getDataFromPreviousScreen();
        if (state != null) {
            viewModel.data = state.data;
        }

        if (viewModel.data == null) {
            // call the model
            String data = model.fetchData();

            // set initial state
            viewModel.data = data;
        }

        // update the view
        view.get().displayData(viewModel);

    }

    @Override
    public void startNewTheoryScreen() {
        router.navigateToNewTheoryScreen();
    }


}
