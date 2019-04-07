package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.place_detail.PlaceDetailContract;
import es.ulpgc.miguel.fortguide.place_detail.PlaceDetailPresenter;
import es.ulpgc.miguel.fortguide.place_detail.PlaceDetailState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlaceDetailPresenterMockitoTest {

  @Mock
  private PlaceDetailContract.Model modelMock;

  @Mock
  private PlaceDetailContract.View viewMock;

  @Mock
  private PlaceDetailContract.Router routerMock;

  private PlaceDetailContract.Presenter presenter;

  @Before
  public void setupMenuScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new PlaceDetailPresenter(new PlaceDetailState());

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

