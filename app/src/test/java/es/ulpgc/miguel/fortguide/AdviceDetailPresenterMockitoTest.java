package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.advice_detail.AdviceDetailContract;
import es.ulpgc.miguel.fortguide.advice_detail.AdviceDetailPresenter;
import es.ulpgc.miguel.fortguide.advice_detail.AdviceDetailState;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AdviceDetailPresenterMockitoTest {

  @Mock
  private AdviceDetailContract.Model modelMock;

  @Mock
  private AdviceDetailContract.View viewMock;

  @Mock
  private AdviceDetailContract.Router routerMock;

  private AdviceDetailContract.Presenter presenter;

  @Before
  public void setupAdviceDetailScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new AdviceDetailPresenter(new AdviceDetailState());

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
