package es.ulpgc.miguel.fortguide.theory_detail;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class TheoryDetailScreen {

  public static void configure(TheoryDetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    TheoryDetailState state = mediator.getTheoryDetailState();

    TheoryDetailContract.Router router = new TheoryDetailRouter(mediator);
    TheoryDetailContract.Presenter presenter = new TheoryDetailPresenter(state);
    TheoryDetailContract.Model model = new TheoryDetailModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
