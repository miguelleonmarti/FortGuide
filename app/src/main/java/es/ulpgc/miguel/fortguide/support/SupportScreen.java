package es.ulpgc.miguel.fortguide.support;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.challenge.SupportRepository;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class SupportScreen {

  public static void configure(SupportContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    SupportState state = mediator.getSupportState();

    RepositoryContract repository = SupportRepository.getInstance(context.get());

    SupportContract.Router router = new SupportRouter(mediator);
    SupportContract.Presenter presenter = new SupportPresenter(state);
    SupportModel model = new SupportModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
