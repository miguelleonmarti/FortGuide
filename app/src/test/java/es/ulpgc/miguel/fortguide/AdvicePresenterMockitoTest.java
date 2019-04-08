package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.advice.AdviceContract;
import es.ulpgc.miguel.fortguide.advice.AdvicePresenter;
import es.ulpgc.miguel.fortguide.advice.AdviceState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdvicePresenterMockitoTest {

  @Mock
  private AdviceContract.Model modelMock;

  @Mock
  private AdviceContract.View viewMock;

  @Mock
  private AdviceContract.Router routerMock;

  private AdviceContract.Presenter presenter;

  @Before
  public void setupMenuScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new AdvicePresenter(new AdviceState());

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
