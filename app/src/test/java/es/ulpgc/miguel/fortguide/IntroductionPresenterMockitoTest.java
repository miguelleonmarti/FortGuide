package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.TestEspresso.IntroductionContract;
import es.ulpgc.miguel.fortguide.TestEspresso.IntroductionPresenter;
import es.ulpgc.miguel.fortguide.TestEspresso.IntroductionState;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class IntroductionPresenterMockitoTest {

  @Mock
  private IntroductionContract.Model modelMock;

  @Mock
  private IntroductionContract.View viewMock;

  @Mock
  private IntroductionContract.Router routerMock;

  private IntroductionContract.Presenter presenter;

  @Before
  public void setupIntroductionScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new IntroductionPresenter(new IntroductionState());

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

  /*
  @Test
  public void initializedNoButtonPressed(){
    IntroductionState viewModel = new IntroductionState();
    viewModel.data="";
    presenter.fetchData();
    verify(viewMock).displayData(viewModel);
  }
*/
}
