package es.ulpgc.miguel.fortguide.support_profile;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.SupportItem;

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
        SupportItem supportItem = router.getDataFromSupportScreen();
        if (supportItem != null) {
            viewModel.data = supportItem.content;
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
