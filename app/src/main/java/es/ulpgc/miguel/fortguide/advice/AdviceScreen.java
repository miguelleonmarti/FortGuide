package es.ulpgc.miguel.fortguide.advice;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class AdviceScreen {

    public static void configure(AdviceContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AdviceState state = mediator.getAdviceState();

        AdviceContract.Router router = new AdviceRouter(mediator);
        AdviceContract.Presenter presenter = new AdvicePresenter(state);
        AdviceContract.Model model = new AdviceModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
