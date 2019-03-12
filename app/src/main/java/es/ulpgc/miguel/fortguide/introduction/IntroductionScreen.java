package es.ulpgc.miguel.fortguide.introduction;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class IntroductionScreen {

    public static void configure(IntroductionContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        IntroductionState state = mediator.getIntroductionState();

        IntroductionContract.Router router = new IntroductionRouter(mediator);
        IntroductionContract.Presenter presenter = new IntroductionPresenter(state);
        IntroductionContract.Model model = new IntroductionModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
