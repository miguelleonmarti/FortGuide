package es.ulpgc.miguel.fortguide.challenges;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class ChallengeListScreen {

    public static void configure(ChallengeListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ChallengeListListState state = mediator.getChallengeListState();

        ChallengeListContract.Router router = new ChallengeListRouter(mediator);
        ChallengeListContract.Presenter presenter = new ChallengeListPresenter(state);
        ChallengeListContract.Model model = new ChallengeListModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
