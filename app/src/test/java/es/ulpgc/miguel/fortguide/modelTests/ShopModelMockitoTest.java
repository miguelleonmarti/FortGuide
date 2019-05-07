package es.ulpgc.miguel.fortguide.modelTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.ShopItem;
import es.ulpgc.miguel.fortguide.shop.ShopContract;
import es.ulpgc.miguel.fortguide.shop.ShopModel;


import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ShopModelMockitoTest {

  @Captor
  private ArgumentCaptor<RepositoryContract.FetchShopDataCallback> callbackCaptor;

  @Mock
  private RepositoryContract repositoryMock;

  private ShopContract.Model model;

  private RepositoryContract.GetShopListCallback callback = new RepositoryContract.GetShopListCallback() {
    @Override
    public void setShopList(List<ShopItem> shopList) {

    }
  };

  private static final boolean clearFirst = true;
  private static final boolean error = false;

  @Before
  public void setupSupportScreen() {
    model = new ShopModel(repositoryMock);
  }

  @Test
  public void fetchDataAsyncTask() {
    model.fetchData(callback);
    verify(repositoryMock).loadShop(eq(clearFirst), callbackCaptor.capture());
    callbackCaptor.getValue().onShopDataFetched(error);
    verify(repositoryMock).getShopList(callback);
  }
}
