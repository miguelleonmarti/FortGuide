package es.ulpgc.miguel.fortguide.advice_detail;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;

import java.lang.ref.WeakReference;


public class AdviceDetailScreen {

  public static void configure(AdviceDetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AdviceDetailState state = mediator.getAdviceDetailState();

    AdviceDetailContract.Router router = new AdviceDetailRouter(mediator);
    AdviceDetailContract.Presenter presenter = new AdviceDetailPresenter(state);
    AdviceDetailContract.Model model = new AdviceDetailModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
