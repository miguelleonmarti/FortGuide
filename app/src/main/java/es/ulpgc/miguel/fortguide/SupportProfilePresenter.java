package es.ulpgc.miguel.fortguide;

import android.util.Log;

import java.lang.ref.WeakReference;

public class SupportProfilePresenter implements SupportProfileContract.Presenter {

    public static String TAG = SupportProfilePresenter.class.getSimpleName();

    private WeakReference<SupportProfileContract.View> view;
    private SupportProfileViewModel viewModel;
    private SupportProfileContract.Model model;
    private SupportProfileContract.Router router;

    public SupportProfilePresenter(SupportProfileState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<SupportProfileContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SupportProfileContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(SupportProfileContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        SupportProfileState state = router.getDataFromPreviousScreen();
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
