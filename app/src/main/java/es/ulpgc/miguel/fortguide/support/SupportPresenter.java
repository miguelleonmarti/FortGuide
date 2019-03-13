package es.ulpgc.miguel.fortguide.support;

import java.lang.ref.WeakReference;

public class SupportPresenter implements SupportContract.Presenter {

    public static String TAG = SupportPresenter.class.getSimpleName();

    private WeakReference<SupportContract.View> view;
    private SupportViewModel viewModel;
    private SupportContract.Model model;
    private SupportContract.Router router;

    public SupportPresenter(SupportState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<SupportContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SupportContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(SupportContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        SupportState state = router.getDataFromPreviousScreen();
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


}
