package es.ulpgc.miguel.fortguide.challenge;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class ChallengesDetailScreen {

    public static void configure(ChallengesDetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ChallengesDetailState state = mediator.getChallengesDetailState();

        ChallengesDetailContract.Router router = new ChallengesDetailRouter(mediator);
        ChallengesDetailContract.Presenter presenter = new ChallengesDetailPresenter(state);
        ChallengesDetailContract.Model model = new ChallengesDetailModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
