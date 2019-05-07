package es.ulpgc.miguel.fortguide.modelTests;

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
import es.ulpgc.miguel.fortguide.weapon.WeaponModel;
import es.ulpgc.miguel.fortguide.weapon.WeaponPresenter;
import es.ulpgc.miguel.fortguide.weapon.WeaponState;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeaponModelMockitoTest {

  @Captor
  private ArgumentCaptor<RepositoryContract.FetchWeaponDataCallback> callbackCaptor;

  @Mock
  private WeaponContract.Presenter presenterMock;

  @Mock
  private WeaponContract.View viewMock;

  @Mock
  private WeaponContract.Router routerMock;

  private WeaponContract.Model model;

  @Mock
  private RepositoryContract repositoryMock;

  private RepositoryContract.GetWeaponListCallback callback = new RepositoryContract.GetWeaponListCallback() {
    @Override
    public void setWeaponList(List<WeaponItem> weaponList) {

    }
  };
  private static final String rarity = "legendary";
  private static final boolean clearFirst = true;
  private static final boolean error = false;

  @Before
  public void setupWeaponScreen() {
    model = new WeaponModel(repositoryMock);

  }

  @Test
  public void dummy() {

  }
  /*@Test
  public void fetchDataAsyncTask() {
    model.fetchData(rarity, callback);
    verify(repositoryMock).loadWeapon(eq(clearFirst), callbackCaptor.capture());
    callbackCaptor.getValue().onWeaponDataFetched(eq(error));
    verify(repositoryMock).getWeaponList(eq(rarity), callback);
  }*/

  /*  @Override
  public void fetchData(final String rarity, final RepositoryContract.GetWeaponListCallback callback) {
    repository.loadWeapon(true, new RepositoryContract.FetchWeaponDataCallback() {
      @Override
      public void onWeaponDataFetched(boolean error) {
        if (!error) {
          repository.getWeaponList(rarity, callback);
        }
      }
    });
  }*/


}


