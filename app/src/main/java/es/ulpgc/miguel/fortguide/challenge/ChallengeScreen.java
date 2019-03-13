package es.ulpgc.miguel.fortguide.challenge;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class ChallengeScreen {

    public static void configure(ChallengeContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ChallengeState state = mediator.getChallengeState();

        ChallengeContract.Router router = new ChallengeRouter(mediator);
        ChallengeContract.Presenter presenter = new ChallengePresenter(state);
        ChallengeContract.Model model = new ChallengeModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
