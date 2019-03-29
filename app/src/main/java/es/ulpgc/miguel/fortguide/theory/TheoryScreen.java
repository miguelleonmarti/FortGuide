package es.ulpgc.miguel.fortguide.theory;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class TheoryScreen {

  public static void configure(TheoryContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    TheoryState state = mediator.getTheoryState();

    TheoryContract.Router router = new TheoryRouter(mediator);
    TheoryContract.Presenter presenter = new TheoryPresenter(state);
    TheoryContract.Model model = new TheoryModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
