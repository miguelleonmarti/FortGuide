package es.ulpgc.miguel.fortguide.challenge;

import java.lang.ref.WeakReference;

public class ChallengesDetailPresenter implements ChallengesDetailContract.Presenter {

    public static String TAG = ChallengesDetailPresenter.class.getSimpleName();

    private WeakReference<ChallengesDetailContract.View> view;
    private ChallengesDetailViewModel viewModel;
    private ChallengesDetailContract.Model model;
    private ChallengesDetailContract.Router router;

    public ChallengesDetailPresenter(ChallengesDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<ChallengesDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ChallengesDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ChallengesDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        ChallengesDetailState state = router.getDataFromPreviousScreen();
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
