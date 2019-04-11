package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.lang.ref.WeakReference;
import es.ulpgc.miguel.fortguide.weapon.WeaponContract;
import es.ulpgc.miguel.fortguide.weapon.WeaponPresenter;
import es.ulpgc.miguel.fortguide.weapon.WeaponState;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeaponPresenterMockitoTest {

  @Mock
  private WeaponContract.Model modelMock;

  @Mock
  private WeaponContract.View viewMock;

  @Mock
  private WeaponContract.Router routerMock;

  private WeaponContract.Presenter presenter;

  @Before
  public void setupWeaponScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new WeaponPresenter(new WeaponState());

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

