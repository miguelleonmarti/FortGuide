package es.ulpgc.miguel.fortguide.weapon;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class WeaponScreen {

    public static void configure(WeaponContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        WeaponState state = mediator.getWeaponState();

        WeaponContract.Router router = new WeaponRouter(mediator);
        WeaponContract.Presenter presenter = new WeaponPresenter(state);
        WeaponContract.Model model = new WeaponModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
