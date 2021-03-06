package es.ulpgc.miguel.fortguide.shop;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.fortguide.app.AppMediator;
import es.ulpgc.miguel.fortguide.app.AppRepository;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ShopScreen {

  public static void configure(ShopContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ShopState state = mediator.getShopState();
    RepositoryContract repository = AppRepository.getInstance(context.get());

    ShopContract.Router router = new ShopRouter(mediator);
    ShopContract.Presenter presenter = new ShopPresenter(state);
    ShopContract.Model model = new ShopModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
