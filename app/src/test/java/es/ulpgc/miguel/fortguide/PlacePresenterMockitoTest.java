package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.place.PlaceContract;
import es.ulpgc.miguel.fortguide.place.PlacePresenter;
import es.ulpgc.miguel.fortguide.place.PlaceState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlacePresenterMockitoTest {

  @Mock
  private PlaceContract.Model modelMock;

  @Mock
  private PlaceContract.View viewMock;

  @Mock
  private PlaceContract.Router routerMock;

  private PlaceContract.Presenter presenter;

  @Before
  public void setupPlaceScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new PlacePresenter(new PlaceState());

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

  //TODO: FALTAN METODOS QUE TESTEAR


}
