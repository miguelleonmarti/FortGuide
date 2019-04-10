package es.ulpgc.miguel.fortguide.menu;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.app.AppRepository;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class MenuScreen {

  public static void configure(MenuContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    MenuState state = mediator.getMenuState();
    RepositoryContract repository = AppRepository.getInstance(context.get());

    MenuContract.Router router = new MenuRouter(mediator);
    MenuContract.Presenter presenter = new MenuPresenter(state);
    MenuModel model = new MenuModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
