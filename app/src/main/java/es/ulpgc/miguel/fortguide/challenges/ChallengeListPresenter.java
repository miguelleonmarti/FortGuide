package es.ulpgc.miguel.fortguide.challenges;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;

public class ChallengeListPresenter implements ChallengeListContract.Presenter {

    public static String TAG = ChallengeListPresenter.class.getSimpleName();

    private WeakReference<ChallengeListContract.View> view;
    private ChallengeListViewModel viewModel;
    private ChallengeListContract.Model model;
    private ChallengeListContract.Router router;

    public ChallengeListPresenter(ChallengeListListState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<ChallengeListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ChallengeListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ChallengeListContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
       viewModel.challenges = (ArrayList<ChallengeItem>) model.fetchChallengeListData();
       view.get().displayData(viewModel);

    }

    @Override
    public void startMenuScreen() {
        router.navigateToMenuScreen();
    }
}
