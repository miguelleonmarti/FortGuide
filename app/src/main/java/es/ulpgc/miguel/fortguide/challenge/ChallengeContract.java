package es.ulpgc.miguel.fortguide.challenge;

import java.lang.ref.WeakReference;

interface ChallengeContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ChallengeViewModel viewModel);
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

        void passDataToNextScreen(ChallengeState state);

        ChallengeState getDataFromPreviousScreen();
    }
}
