package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.theory_detail.TheoryDetailContract;
import es.ulpgc.miguel.fortguide.theory_detail.TheoryDetailPresenter;
import es.ulpgc.miguel.fortguide.theory_detail.TheoryDetailState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TheoryDetailPresenterMockitoTest {

  @Mock
  private TheoryDetailContract.Model modelMock;

  @Mock
  private TheoryDetailContract.View viewMock;

  @Mock
  private TheoryDetailContract.Router routerMock;

  private TheoryDetailContract.Presenter presenter;

  @Before
  public void setupTheoryDetailScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new TheoryDetailPresenter(new TheoryDetailState());

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
