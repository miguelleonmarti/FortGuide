package es.ulpgc.miguel.fortguide.weapon_detail;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;

public class WeaponDetailScreen {

  public static void configure(WeaponDetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    WeaponDetailState state = mediator.getWeaponDetailState();

    WeaponDetailContract.Router router = new WeaponDetailRouter(mediator);
    WeaponDetailContract.Presenter presenter = new WeaponDetailPresenter(state);
    WeaponDetailContract.Model model = new WeaponDetailModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
