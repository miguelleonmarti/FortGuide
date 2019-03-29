package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;


import es.ulpgc.miguel.fortguide.menu.MenuContract;
import es.ulpgc.miguel.fortguide.menu.MenuPresenter;
import es.ulpgc.miguel.fortguide.menu.MenuState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuPresenterMockitoTest {

  @Mock
  private MenuContract.Model modelMock;

  @Mock
  private MenuContract.View viewMock;

  @Mock
  private MenuContract.Router routerMock;

  private MenuContract.Presenter presenter;

  @Before
  public void setupMenuScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new MenuPresenter(new MenuState());

    // Inject dependencies to the class under test
    presenter.injectView(new WeakReference<>(viewMock));
    presenter.injectModel(modelMock);
    presenter.injectRouter(routerMock);

  }
  @Test
  public void goToWeaponScreen(){
    presenter.startWeaponScreen();
    verify(routerMock).navigateToWeaponScreen();
  }

  @Test
  public void goToAdviceScreen(){
    presenter.startAdviceScreen();
    verify(routerMock).navigateToAdviceScreen();
  }
  @Test
  public void goToPlaceScreen(){
    presenter.startPlaceScreen();
    verify(routerMock).navigateToPlaceScreen();
  }
  @Test
  public void goToSupportScreen(){
    presenter.startWeaponScreen();
    verify(routerMock).navigateToWeaponScreen();
  }
  @Test
  public void goToTheoryScreen(){
    presenter.startTheoryScreen();
    verify(routerMock).navigateToTheoryScreen();
  }
  @Test
  public void goToChallengeScreen(){
    presenter.startChallengeScreen();
    verify(routerMock).navigateToChallengeScreen();
  }
//TODO hacer le test paracambiar a tienda

}
