package es.ulpgc.miguel.fortguide;

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

import es.ulpgc.miguel.fortguide.data.PlaceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.place.PlaceContract;
import es.ulpgc.miguel.fortguide.place.PlacePresenter;
import es.ulpgc.miguel.fortguide.place.PlaceState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlacePresenterMockitoTest {

  @Captor
  private ArgumentCaptor<RepositoryContract.GetPlaceListCallback> callbackCaptor;

  @Mock
  private PlaceContract.Model modelMock;

  @Mock
  private PlaceContract.View viewMock;

  @Mock
  private PlaceContract.Router routerMock;

  private PlaceContract.Presenter presenter;
  private PlaceState placeState;

  @Before
  public void setupPlaceScreen() {

    placeState = new PlaceState();

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new PlacePresenter(placeState);

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
  public void goToPlaceDetailScreen() {
    PlaceItem placeItem = new PlaceItem(1,"","","","","");
    presenter.selectPlaceListData(placeItem);
    verify(routerMock).passDataToNextScreen(placeItem);
    verify(routerMock).navigateToPlaceDetailScreen();
  }

  @Test
  public void fetchDataAsyncTask() {
    when(routerMock.getDataFromPreviousScreen()).thenReturn(new PlaceState());

    List<PlaceItem> placeList = new ArrayList<>();
    placeList.add(new PlaceItem(1, "", "", "", "", ""));
    placeList.add(new PlaceItem(2, "", "", "", "", ""));

    placeState.placeItemList = null;

    presenter.fetchData();

    verify(modelMock).fetchPlaceListData(callbackCaptor.capture());
    callbackCaptor.getValue().setPlaceList(placeList);


    placeState.placeItemList = placeList;
    placeState.places = placeList;

    verify(viewMock).displayData(placeState);
  }


}
