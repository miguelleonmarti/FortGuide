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
import es.ulpgc.miguel.fortguide.data.WeaponItem;
import es.ulpgc.miguel.fortguide.support.SupportContract;
import es.ulpgc.miguel.fortguide.support.SupportModel;
import es.ulpgc.miguel.fortguide.weapon.WeaponContract;
import es.ulpgc.miguel.fortguide.weapon.WeaponModel;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SupportModelMockitoTest {

    @Captor
    private ArgumentCaptor<RepositoryContract.FetchSupportDataCallback> callbackCaptor;

    @Mock
    private RepositoryContract repositoryMock;

    private SupportContract.Model model;

    private RepositoryContract.GetSupportListCallback callback = new RepositoryContract.GetSupportListCallback() {
      @Override
      public void setSupportList(List<SupportItem> supportList) {

      }
    };

    private static final boolean clearFirst = true;
    private static final boolean error = false;

    @Before
    public void setupSupportScreen() {
      model = new SupportModel(repositoryMock);
    }

    @Test
    public void fetchDataAsyncTask() {
      model.fetchSupportListData(callback);
      verify(repositoryMock).loadSupport(eq(clearFirst), callbackCaptor.capture());
      callbackCaptor.getValue().onSupportDataFetched(error);
      verify(repositoryMock).getSupportList(callback);
    }
}
