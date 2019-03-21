package es.ulpgc.miguel.fortguide.advice;

import java.lang.ref.WeakReference;

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
        // Log.e(TAG, "fetchData()");

        // set passed state
        AdviceState state = router.getDataFromPreviousScreen();
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
