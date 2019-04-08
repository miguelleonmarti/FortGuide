package es.ulpgc.miguel.fortguide.challenges_detail;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.challenge.AppRepository;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengesDetailListScreen {

  public static void configure(ChallengesDetailListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ChallengesDetailListState state = mediator.getChallengesDetailState();
    RepositoryContract repository = AppRepository.getInstance(context.get());

    ChallengesDetailListContract.Router router = new ChallengesDetailListRouter(mediator);
    ChallengesDetailListContract.Presenter presenter = new ChallengesDetailListPresenter(state);
    ChallengesDetailListContract.Model model = new ChallengesDetailListModel(repository);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }
}
