package es.ulpgc.miguel.fortguide.challenges_weeks;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.challenge.AppRepository;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class WeeksListScreen {

  public static void configure(WeeksListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    WeeksListState state = mediator.getWeeksListState();
    RepositoryContract repository = AppRepository.getInstance(context.get());

    WeeksListContract.Router router = new WeeksListRouter(mediator);
    WeeksListContract.Presenter presenter = new WeeksListPresenter(state);
    WeeksListContract.Model model = new WeeksListModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
