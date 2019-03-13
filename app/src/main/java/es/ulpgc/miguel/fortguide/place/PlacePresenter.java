package es.ulpgc.miguel.fortguide.place;

import java.lang.ref.WeakReference;

public class PlacePresenter implements PlaceContract.Presenter {

    public static String TAG = PlacePresenter.class.getSimpleName();

    private WeakReference<PlaceContract.View> view;
    private PlaceViewModel viewModel;
    private PlaceContract.Model model;
    private PlaceContract.Router router;

    public PlacePresenter(PlaceState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<PlaceContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PlaceContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(PlaceContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        PlaceState state = router.getDataFromPreviousScreen();
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
