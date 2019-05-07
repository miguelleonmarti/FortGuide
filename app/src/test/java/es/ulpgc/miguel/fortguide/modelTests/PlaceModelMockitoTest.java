package es.ulpgc.miguel.fortguide.modelTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.place.PlaceContract;
import es.ulpgc.miguel.fortguide.place.PlaceModel;
import es.ulpgc.miguel.fortguide.support.SupportContract;
import es.ulpgc.miguel.fortguide.support.SupportModel;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PlaceModelMockitoTest {

  @Captor
  private ArgumentCaptor<RepositoryContract.FetchPlaceDataCallback> callbackCaptor;

  @Mock
  private RepositoryContract repositoryMock;

  private PlaceContract.Model model;

  private RepositoryContract.GetPlaceListCallback callback = new RepositoryContract.GetPlaceListCallback() {
    @Override
    public void setPlaceList(List<PlaceItem> placeList) {

    }
  };

  private static final boolean clearFirst = true;
  private static final boolean error = false;

  @Before
  public void setupSupportScreen() {
    model = new PlaceModel(repositoryMock);
  }

  @Test
  public void fetchDataAsyncTask() {
    model.fetchPlaceListData(callback);
    verify(repositoryMock).loadPlace(eq(clearFirst), callbackCaptor.capture());
    callbackCaptor.getValue().onPlaceDataFetched(error);
    verify(repositoryMock).getPlaceList(callback);
  }
}
