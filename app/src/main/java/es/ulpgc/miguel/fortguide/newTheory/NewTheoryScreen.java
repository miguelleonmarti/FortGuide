package es.ulpgc.miguel.fortguide.newTheory;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class NewTheoryScreen {

    public static void configure(NewTheoryContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        NewTheoryState state = mediator.getNewTheoryState();

        NewTheoryContract.Router router = new NewTheoryRouter(mediator);
        NewTheoryContract.Presenter presenter = new NewTheoryPresenter(state);
        NewTheoryContract.Model model = new NewTheoryModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
