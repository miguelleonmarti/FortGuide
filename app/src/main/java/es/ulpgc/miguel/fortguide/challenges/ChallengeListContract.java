package es.ulpgc.miguel.fortguide.challenges;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;

interface ChallengeListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ChallengeListViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void startMenuScreen();
    }

    interface Model {
        List<ChallengeItem> fetchChallengeListData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(ChallengeListListState state);

        ChallengeListListState getDataFromPreviousScreen();

        void navigateToMenuScreen();
    }
}
