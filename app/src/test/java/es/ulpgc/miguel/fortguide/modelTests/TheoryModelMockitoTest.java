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
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.data.TheoryItem;
import es.ulpgc.miguel.fortguide.shop.ShopContract;
import es.ulpgc.miguel.fortguide.shop.ShopModel;
import es.ulpgc.miguel.fortguide.support.SupportContract;
import es.ulpgc.miguel.fortguide.support.SupportModel;
import es.ulpgc.miguel.fortguide.theory.TheoryContract;
import es.ulpgc.miguel.fortguide.theory.TheoryModel;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TheoryModelMockitoTest {
  @Captor
  private ArgumentCaptor<RepositoryContract.FetchTheoryDataCallback> callbackCaptor;

  @Mock
  private RepositoryContract repositoryMock;

  private TheoryContract.Model model;

  private RepositoryContract.GetTheoryListCallback callback = new RepositoryContract.GetTheoryListCallback() {
    @Override
    public void setTheoryList(List<TheoryItem> theoryList) {

    }
  };

  private static final boolean clearFirst = true;
  private static final boolean error = false;

  @Before
  public void setupSupportScreen() {
    model = new TheoryModel(repositoryMock);
  }

  @Test
  public void fetchDataAsyncTask() {
    model.fetchTheoryListData(callback);
    verify(repositoryMock).loadTheory(eq(clearFirst), callbackCaptor.capture());
    callbackCaptor.getValue().onTheoryDataFetched(error);
    verify(repositoryMock).getTheoryList(callback);
  }
}
