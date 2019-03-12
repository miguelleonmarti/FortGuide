package es.ulpgc.miguel.fortguide.menu;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class MenuScreen {

    public static void configure(MenuContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        MenuState state = mediator.getMenuState();

        MenuContract.Router router = new MenuRouter(mediator);
        MenuContract.Presenter presenter = new MenuPresenter(state);
        MenuContract.Model model = new MenuModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
