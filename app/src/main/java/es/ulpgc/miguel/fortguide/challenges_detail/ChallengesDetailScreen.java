package es.ulpgc.miguel.fortguide.challenges_detail;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.challenge.AppRepository;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengesDetailScreen {

  public static void configure(ChallengesDetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ChallengesDetailState state = mediator.getChallengesDetailState();
    RepositoryContract repository = AppRepository.getInstance(context.get());

    ChallengesDetailContract.Router router = new ChallengesDetailRouter(mediator);
    ChallengesDetailContract.Presenter presenter = new ChallengesDetailPresenter(state);
    ChallengesDetailContract.Model model = new ChallengesDetailModel(repository);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }
}
