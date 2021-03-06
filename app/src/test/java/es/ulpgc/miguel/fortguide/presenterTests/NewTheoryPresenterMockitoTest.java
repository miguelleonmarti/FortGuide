package es.ulpgc.miguel.fortguide.presenterTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.newTheory.NewTheoryContract;
import es.ulpgc.miguel.fortguide.newTheory.NewTheoryPresenter;
import es.ulpgc.miguel.fortguide.newTheory.NewTheoryState;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NewTheoryPresenterMockitoTest {

  @Captor
  private ArgumentCaptor<RepositoryContract.InsertTheoryCallback> callbackCaptor;

  @Mock
  private NewTheoryContract.Model modelMock;

  @Mock
  private NewTheoryContract.View viewMock;

  @Mock
  private NewTheoryContract.Router routerMock;

  private NewTheoryContract.Presenter presenter;

  private static final String user = "";
  private static final String nameTheory = "";
  private static final String description = "";

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
  public void insertNewTheory() {
    presenter.insertNewTheory(user, nameTheory, description);
    verify(modelMock).insertTheory(eq(user), eq(nameTheory), eq(description), callbackCaptor.capture());
    callbackCaptor.getValue().theoryInserted();
    verify(viewMock).onTheoryInserted();
  }
}
