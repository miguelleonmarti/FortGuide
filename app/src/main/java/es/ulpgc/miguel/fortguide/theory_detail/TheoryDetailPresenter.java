package es.ulpgc.miguel.fortguide.theory_detail;

import java.lang.ref.WeakReference;

public class TheoryDetailPresenter implements TheoryDetailContract.Presenter {

    public static String TAG = TheoryDetailPresenter.class.getSimpleName();

    private WeakReference<TheoryDetailContract.View> view;
    private TheoryDetailViewModel viewModel;
    private TheoryDetailContract.Model model;
    private TheoryDetailContract.Router router;

    public TheoryDetailPresenter(TheoryDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<TheoryDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(TheoryDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(TheoryDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        TheoryDetailState state = router.getDataFromPreviousScreen();
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
    public void startMenuScreen() {
        router.navigateToMenuScreen();
    }
}
