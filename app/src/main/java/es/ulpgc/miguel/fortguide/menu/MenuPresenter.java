package es.ulpgc.miguel.fortguide.menu;

import java.lang.ref.WeakReference;

public class MenuPresenter implements MenuContract.Presenter {

    public static String TAG = MenuPresenter.class.getSimpleName();

    private WeakReference<MenuContract.View> view;
    private MenuViewModel viewModel;
    private MenuContract.Model model;
    private MenuContract.Router router;

    public MenuPresenter(MenuState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<MenuContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(MenuContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(MenuContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        MenuState state = router.getDataFromPreviousScreen();
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
    public void startAdviceScreen() {
        router.navigateToAdviceScreen();
    }

    @Override
    public void startChallengeScreen() {
        router.navigateToChallengeScreen();
    }

    @Override
    public void startPlaceScreen() {
        router.navigateToPlaceScreen();
    }

    @Override
    public void startShopScreen() {
        router.navigateToShopScreen();
    }

    @Override
    public void startSupportScreen() {
        router.navigateToSupportScreen();
    }

    @Override
    public void startTheoryScreen() {
        router.navigateToTheoryScreen();
    }

    @Override
    public void startWeaponScreen() {
        router.navigateToWeaponScreen();
    }
}
