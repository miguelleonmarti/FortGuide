package es.ulpgc.miguel.fortguide.weapon;

import java.lang.ref.WeakReference;

interface WeaponContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(WeaponViewModel viewModel);
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

        void passDataToNextScreen(WeaponState state);

        WeaponState getDataFromPreviousScreen();
    }
}
