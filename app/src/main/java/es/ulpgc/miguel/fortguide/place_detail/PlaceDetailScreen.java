package es.ulpgc.miguel.fortguide.place_detail;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class PlaceDetailScreen {

  public static void configure(PlaceDetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    PlaceDetailState state = mediator.getPlaceDetailState();

    PlaceDetailContract.Router router = new PlaceDetailRouter(mediator);
    PlaceDetailContract.Presenter presenter = new PlaceDetailPresenter(state);
    PlaceDetailContract.Model model = new PlaceDetailModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
