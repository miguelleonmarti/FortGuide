package es.ulpgc.miguel.fortguide.support;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class SupportScreen {

    public static void configure(SupportContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        SupportState state = mediator.getSupportState();

        SupportContract.Router router = new SupportRouter(mediator);
        SupportContract.Presenter presenter = new SupportPresenter(state);
        SupportContract.Model model = new SupportModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
