package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.newTheory.NewTheoryContract;
import es.ulpgc.miguel.fortguide.newTheory.NewTheoryPresenter;
import es.ulpgc.miguel.fortguide.newTheory.NewTheoryState;
import es.ulpgc.miguel.fortguide.newTheory.NewTheoryViewModel;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NewTheoryPresenterMockitoTest {

  @Mock
  private NewTheoryContract.Model modelMock;

  @Mock
  private NewTheoryContract.View viewMock;

  @Mock
  private NewTheoryContract.Router routerMock;

  private NewTheoryContract.Presenter presenter;

  @Before
  public void setupNewTheoryScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new NewTheoryPresenter(new NewTheoryState());

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
  public void fetchNewTheoryData() {
    NewTheoryViewModel newTheoryViewModel = new NewTheoryViewModel();
    presenter.fetchData();
    verify(viewMock).displayData(newTheoryViewModel);
  }

}
