package es.ulpgc.miguel.fortguide.challenges_detail;

import java.lang.ref.WeakReference;

interface ChallengesDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ChallengesDetailViewModel viewModel);
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

        void passDataToNextScreen(ChallengesDetailState state);

        ChallengesDetailState getDataFromPreviousScreen();
    }
}
