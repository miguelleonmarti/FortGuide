package es.ulpgc.miguel.fortguide.advice_detail;

import android.util.Log;

import java.lang.ref.WeakReference;

public class AdviceDetailPresenter implements AdviceDetailContract.Presenter {

    public static String TAG = AdviceDetailPresenter.class.getSimpleName();

    private WeakReference<AdviceDetailContract.View> view;
    private AdviceDetailViewModel viewModel;
    private AdviceDetailContract.Model model;
    private AdviceDetailContract.Router router;

    public AdviceDetailPresenter(AdviceDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AdviceDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AdviceDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AdviceDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        AdviceDetailState state = router.getDataFromPreviousScreen();
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
