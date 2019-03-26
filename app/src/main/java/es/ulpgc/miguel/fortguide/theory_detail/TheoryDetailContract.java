package es.ulpgc.miguel.fortguide.theory_detail;

import java.lang.ref.WeakReference;

interface TheoryDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(TheoryDetailViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void startMenuScreen();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(TheoryDetailState state);

        TheoryDetailState getDataFromPreviousScreen();

        void navigateToMenuScreen();
    }
}
