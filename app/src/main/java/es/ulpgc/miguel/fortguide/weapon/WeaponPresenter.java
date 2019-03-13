package es.ulpgc.miguel.fortguide.weapon;

import java.lang.ref.WeakReference;

public class WeaponPresenter implements WeaponContract.Presenter {

    public static String TAG = WeaponPresenter.class.getSimpleName();

    private WeakReference<WeaponContract.View> view;
    private WeaponViewModel viewModel;
    private WeaponContract.Model model;
    private WeaponContract.Router router;

    public WeaponPresenter(WeaponState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<WeaponContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(WeaponContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(WeaponContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        WeaponState state = router.getDataFromPreviousScreen();
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
