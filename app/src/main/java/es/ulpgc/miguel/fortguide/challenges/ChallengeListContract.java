package es.ulpgc.miguel.fortguide.challenges;

import java.lang.ref.WeakReference;

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
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(ChallengeListListState state);

        ChallengeListListState getDataFromPreviousScreen();
    }
}
