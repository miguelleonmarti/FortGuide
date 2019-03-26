package es.ulpgc.miguel.fortguide.place;

import java.lang.ref.WeakReference;

interface PlaceContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(PlaceViewModel viewModel);
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

        void passDataToNextScreen(PlaceState state);

        PlaceState getDataFromPreviousScreen();

        void navigateToMenuScreen();
    }
}
