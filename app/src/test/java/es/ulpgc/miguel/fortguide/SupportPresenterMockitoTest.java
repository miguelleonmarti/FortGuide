package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.support.SupportContract;
import es.ulpgc.miguel.fortguide.support.SupportPresenter;
import es.ulpgc.miguel.fortguide.support.SupportState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SupportPresenterMockitoTest {

  @Mock
  private SupportContract.Model modelMock;

  @Mock
  private SupportContract.View viewMock;

  @Mock
  private SupportContract.Router routerMock;

  private SupportContract.Presenter presenter;

  @Before
  public void setupSupportScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new SupportPresenter(new SupportState());

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
  public void selectSupportListData() {
    SupportItem supportItem = new SupportItem(1, "", "", "", "", "", "", "", "");
    presenter.selectSupportListData(supportItem);
    verify(routerMock).passDataToSupportProfileScreen(supportItem);
    verify(routerMock).navigateToSupportProfileScreen();
  }

}
