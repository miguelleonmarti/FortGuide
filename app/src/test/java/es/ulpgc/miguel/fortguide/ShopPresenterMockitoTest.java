package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;


import es.ulpgc.miguel.fortguide.shop.ShopContract;
import es.ulpgc.miguel.fortguide.shop.ShopPresenter;
import es.ulpgc.miguel.fortguide.shop.ShopState;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ShopPresenterMockitoTest {

  @Mock
  private ShopContract.Model modelMock;

  @Mock
  private ShopContract.View viewMock;

  @Mock
  private ShopContract.Router routerMock;

  private ShopContract.Presenter presenter;

  @Before
  public void setupShopScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new ShopPresenter(new ShopState());

    // Inject dependencies to the class under test
    presenter.injectView(new WeakReference<>(viewMock));
    presenter.injectModel(modelMock);
    presenter.injectRouter(routerMock);

  }

  @Test
  public void goToMenuScreen() {
    presenter.startMenuScreen();
    verify(routerMock).navigateToMenuScreen();
  }
}
