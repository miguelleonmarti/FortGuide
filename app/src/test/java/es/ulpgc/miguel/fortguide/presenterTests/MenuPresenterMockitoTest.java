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
import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.menu.MenuContract;
import es.ulpgc.miguel.fortguide.menu.MenuPresenter;
import es.ulpgc.miguel.fortguide.menu.MenuState;
import es.ulpgc.miguel.fortguide.support.SupportState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuPresenterMockitoTest {

  @Captor
  private ArgumentCaptor<RepositoryContract.GetServerStatusCallback> callbackCaptor;

  @Mock
  private MenuContract.Model modelMock;

  @Mock
  private MenuContract.View viewMock;

  @Mock
  private MenuContract.Router routerMock;

  private MenuContract.Presenter presenter;
  private MenuState menuState;

  @Before
  public void setupMenuScreen() {

    menuState = new MenuState();

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new MenuPresenter(menuState);

    // Inject dependencies to the class under test
    presenter.injectView(new WeakReference<>(viewMock));
    presenter.injectModel(modelMock);
    presenter.injectRouter(routerMock);

  }

  @Test
  public void goToWeaponScreen() {
    presenter.startWeaponScreen();
    verify(routerMock).navigateToWeaponScreen();
  }

  @Test
  public void goToAdviceScreen() {
    presenter.startAdviceScreen();
    verify(routerMock).navigateToAdviceScreen();
  }

  @Test
  public void goToPlaceScreen() {
    presenter.startPlaceScreen();
    verify(routerMock).navigateToPlaceScreen();
  }

  @Test
  public void goToSupportScreen() {
    presenter.startWeaponScreen();
    verify(routerMock).navigateToWeaponScreen();
  }

  @Test
  public void goToTheoryScreen() {
    presenter.startTheoryScreen();
    verify(routerMock).navigateToTheoryScreen();
  }

  @Test
  public void goToChallengeScreen() {
    presenter.startChallengeScreen();
    verify(routerMock).navigateToChallengeScreen();
  }

  @Test
  public void goToShopScreen() {
    presenter.startShopScreen();
    verify(routerMock).navigateToShopScreen();
  }

  /*
  model.fetchData(new RepositoryContract.GetServerStatusCallback() {
      @Override
      public void setStatus(boolean status) {
        viewModel.status = status;
        view.get().displayData(viewModel);
      }
    });
   */

  @Test
  public void fetchDataAsyncTask() {
    presenter.fetchData();
    verify(modelMock).fetchData(callbackCaptor.capture());
    callbackCaptor.getValue().setStatus(true);
    menuState.status = true;
    verify(viewMock).displayData(menuState);
  }

}
