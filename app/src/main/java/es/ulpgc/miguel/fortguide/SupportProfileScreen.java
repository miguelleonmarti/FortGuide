package es.ulpgc.miguel.fortguide;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class SupportProfileScreen {

    public static void configure(SupportProfileContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        SupportProfileState state = mediator.getSupportProfileState();

        SupportProfileContract.Router router = new SupportProfileRouter(mediator);
        SupportProfileContract.Presenter presenter = new SupportProfilePresenter(state);
        SupportProfileContract.Model model = new SupportProfileModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
