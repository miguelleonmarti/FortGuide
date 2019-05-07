package es.ulpgc.miguel.fortguide.presenterTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.ShopItem;
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.shop.ShopContract;
import es.ulpgc.miguel.fortguide.shop.ShopPresenter;
import es.ulpgc.miguel.fortguide.shop.ShopState;
import es.ulpgc.miguel.fortguide.support.SupportState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShopPresenterMockitoTest {

  @Captor
  private ArgumentCaptor<RepositoryContract.GetShopListCallback> callbackCaptor;

  @Mock
  private ShopContract.Model modelMock;

  @Mock
  private ShopContract.View viewMock;

  @Mock
  private ShopContract.Router routerMock;

  private ShopContract.Presenter presenter;
  private ShopState shopState;

  @Before
  public void setupShopScreen() {

    shopState = new ShopState();

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new ShopPresenter(shopState);

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

  @Test
  public void fetchDataAsyncTask() {
    when(routerMock.getDataFromPreviousScreen()).thenReturn(new ShopState());

    List<ShopItem> shopList = new ArrayList<>();
    shopList.add(new ShopItem(1,"","",""));
    shopList.add(new ShopItem(2,"","",""));

    shopState.shopItemList = null;

    presenter.fetchData();

    verify(modelMock).fetchData(callbackCaptor.capture());
    callbackCaptor.getValue().setShopList(shopList);

    shopState.shopItemList = shopList;

    verify(viewMock).displayData(shopState);
  }
}
