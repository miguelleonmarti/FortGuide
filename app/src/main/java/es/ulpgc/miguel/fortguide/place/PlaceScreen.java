package es.ulpgc.miguel.fortguide.place;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.challenge.AppRepository;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class PlaceScreen {

  public static void configure(PlaceContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    PlaceState state = mediator.getPlaceState();
    RepositoryContract repository = AppRepository.getInstance(context.get());

    PlaceContract.Router router = new PlaceRouter(mediator);
    PlaceContract.Presenter presenter = new PlacePresenter(state);
    PlaceModel model = new PlaceModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
