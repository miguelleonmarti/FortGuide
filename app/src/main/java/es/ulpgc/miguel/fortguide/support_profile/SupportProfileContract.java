package es.ulpgc.miguel.fortguide.support_profile;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.SupportItem;

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

        void startMenuScreen();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(SupportProfileState state);

        SupportItem getDataFromSupportScreen();

        void navigateToMenuScreen();
    }
}
