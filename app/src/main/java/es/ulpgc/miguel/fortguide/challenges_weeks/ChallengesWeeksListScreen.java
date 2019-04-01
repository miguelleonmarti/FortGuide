package es.ulpgc.miguel.fortguide.challenges_weeks;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.challenge.ChallengeRepository;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengesWeeksListScreen {

  public static void configure(ChallengesWeeksListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ChallengesWeeksListState state = mediator.getChallengesWeeksListState();
    RepositoryContract repository = ChallengeRepository.getInstance(context.get());

    ChallengesWeeksListContract.Router router = new ChallengesWeeksListRouter(mediator);
    ChallengesWeeksListContract.Presenter presenter = new ChallengesWeeksListPresenter(state);
    ChallengesWeeksListContract.Model model = new ChallengesWeeksListModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
