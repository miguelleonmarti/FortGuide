package es.ulpgc.miguel.fortguide.support;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.SupportItem;

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

        // update the view
        viewModel.profiles = model.fetchData();
        view.get().displayData(viewModel);

    }

    @Override
    public void startMenuScreen() {
        router.navigateToMenuScreen();
    }

    @Override
    public void selectCategoryListData(SupportItem item) {
        router.navigateToSupportProfileScreen();
        router.passDataToSupportProfileScreen(item);
    }
}
