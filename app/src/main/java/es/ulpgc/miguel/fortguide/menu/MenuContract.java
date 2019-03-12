package es.ulpgc.miguel.fortguide.menu;

import java.lang.ref.WeakReference;

interface MenuContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(MenuViewModel viewModel);
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

        void passDataToNextScreen(MenuState state);

        MenuState getDataFromPreviousScreen();
    }
}
