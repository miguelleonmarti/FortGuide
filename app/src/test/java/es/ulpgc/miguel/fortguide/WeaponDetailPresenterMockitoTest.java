package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.fortguide.weapon_detail.WeaponDetailContract;
import es.ulpgc.miguel.fortguide.weapon_detail.WeaponDetailPresenter;
import es.ulpgc.miguel.fortguide.weapon_detail.WeaponDetailState;

import static org.mockito.Mockito.verify;

  @RunWith(MockitoJUnitRunner.class)
  public class WeaponDetailPresenterMockitoTest {

    @Mock
    private WeaponDetailContract.Model modelMock;

    @Mock
    private WeaponDetailContract.View viewMock;

    @Mock
    private WeaponDetailContract.Router routerMock;

    private WeaponDetailContract.Presenter presenter;

    @Before
    public void setupWeaponDetailScreen() {

      // To inject the mocks in the test this method needs to be called
      MockitoAnnotations.initMocks(this);

      // Get a reference to the class under test
      presenter = new WeaponDetailPresenter(new WeaponDetailState());

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

