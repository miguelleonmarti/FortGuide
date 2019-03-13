package es.ulpgc.miguel.fortguide.challenge;

import java.lang.ref.WeakReference;

public class ChallengePresenter implements ChallengeContract.Presenter {

    public static String TAG = ChallengePresenter.class.getSimpleName();

    private WeakReference<ChallengeContract.View> view;
    private ChallengeViewModel viewModel;
    private ChallengeContract.Model model;
    private ChallengeContract.Router router;

    public ChallengePresenter(ChallengeState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<ChallengeContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ChallengeContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ChallengeContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        ChallengeState state = router.getDataFromPreviousScreen();
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
