package es.ulpgc.miguel.fortguide;

import java.lang.ref.WeakReference;

interface SupportProfileContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(SupportProfileViewModel viewModel);
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

        void passDataToNextScreen(SupportProfileState state);

        SupportProfileState getDataFromPreviousScreen();
    }
}
