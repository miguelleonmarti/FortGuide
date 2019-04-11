package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.support_profile.SupportProfileContract;
import es.ulpgc.miguel.fortguide.support_profile.SupportProfilePresenter;
import es.ulpgc.miguel.fortguide.support_profile.SupportProfileState;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SupportProfilePresenterMockitoTest {

  @Mock
  private SupportProfileContract.Model modelMock;

  @Mock
  private SupportProfileContract.View viewMock;

  @Mock
  private SupportProfileContract.Router routerMock;

  private SupportProfileContract.Presenter presenter;

  @Before
  public void setupSupportProfileScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new SupportProfilePresenter(new SupportProfileState());

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
  public void goToSocialScreenIG(){
    //presenter.startInstagramScreen();
    //verify(routerMock).navigateToInstagramScreen();
  }
}
