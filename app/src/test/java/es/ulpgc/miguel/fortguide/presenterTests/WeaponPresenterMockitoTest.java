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
import es.ulpgc.miguel.fortguide.data.WeaponItem;
import es.ulpgc.miguel.fortguide.support.SupportState;
import es.ulpgc.miguel.fortguide.weapon.WeaponContract;
import es.ulpgc.miguel.fortguide.weapon.WeaponPresenter;
import es.ulpgc.miguel.fortguide.weapon.WeaponState;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeaponPresenterMockitoTest {

  private static final String rarity = "legendary";

  @Captor
  private ArgumentCaptor<RepositoryContract.GetWeaponListCallback> callbackCaptor;

  @Mock
  private WeaponContract.Model modelMock;

  @Mock
  private WeaponContract.View viewMock;

  @Mock
  private WeaponContract.Router routerMock;

  private WeaponContract.Presenter presenter;
  private WeaponState weaponState;

  @Before
  public void setupWeaponScreen() {

    weaponState = new WeaponState();
    weaponState.weaponItemList = new ArrayList<>();

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new WeaponPresenter(weaponState);

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
  public void fetchDataAsyncTask() {
    when(routerMock.getDataFromPreviousScreen()).thenReturn(new WeaponState());

    List<WeaponItem> weaponList = new ArrayList<>();
    weaponList.add(new WeaponItem("1","","","","","","","","","",""));
    weaponList.add(new WeaponItem("2","","","","","","","","","",""));

    weaponState.weaponItemList = null;

    presenter.fetchData(rarity);

    verify(modelMock).fetchData(eq(rarity),callbackCaptor.capture());
    callbackCaptor.getValue().setWeaponList(weaponList);

    weaponState.weaponItemList = weaponList;

    verify(viewMock).displayData(weaponState);
  }

  /*@Test
  public void refreshUI() {
    when(routerMock.getDataFromPreviousScreen()).thenReturn(new WeaponState());

    weaponState.weaponItemList.add(new WeaponItem("1","","","","","","","","","",""));
    presenter.refreshUI();

    verify(viewMock).displayData(weaponState);
  }*/


}

