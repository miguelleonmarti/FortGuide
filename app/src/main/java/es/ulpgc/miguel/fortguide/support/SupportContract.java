package es.ulpgc.miguel.fortguide.support;

import java.lang.ref.WeakReference;

interface SupportContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(SupportViewModel viewModel);
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

        void passDataToNextScreen(SupportState state);

        SupportState getDataFromPreviousScreen();

        void navigateToMenuScreen();
    }
}
