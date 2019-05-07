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
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.menu.MenuContract;
import es.ulpgc.miguel.fortguide.menu.MenuModel;
import es.ulpgc.miguel.fortguide.support.SupportContract;
import es.ulpgc.miguel.fortguide.support.SupportModel;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MenuModelMockitoTest {

  @Captor
  private ArgumentCaptor<RepositoryContract.FetchServerStatusCallback> callbackCaptor;

  @Mock
  private RepositoryContract repositoryMock;

  private MenuContract.Model model;

  private RepositoryContract.GetServerStatusCallback callback = new RepositoryContract.GetServerStatusCallback() {
    @Override
    public void setStatus(boolean status) {

    }
  };

  private static final boolean error = false;

  @Before
  public void setupSupportScreen() {
    model = new MenuModel(repositoryMock);
  }

  @Test
  public void fetchDataAsyncTask() {
    model.fetchData(callback);
    verify(repositoryMock).loadServerStatus(callbackCaptor.capture());
    callbackCaptor.getValue().onServerStatusFetch(error);
    verify(repositoryMock).getServerStatus(callback);
  }
}
