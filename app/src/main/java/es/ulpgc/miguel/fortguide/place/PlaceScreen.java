package es.ulpgc.miguel.fortguide.place;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class PlaceScreen {

    public static void configure(PlaceContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        PlaceState state = mediator.getPlaceState();

        PlaceContract.Router router = new PlaceRouter(mediator);
        PlaceContract.Presenter presenter = new PlacePresenter(state);
        PlaceContract.Model model = new PlaceModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
