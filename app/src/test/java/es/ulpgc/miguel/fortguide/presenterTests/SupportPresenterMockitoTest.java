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
import es.ulpgc.miguel.fortguide.support.SupportContract;
import es.ulpgc.miguel.fortguide.support.SupportPresenter;
import es.ulpgc.miguel.fortguide.support.SupportState;



import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SupportPresenterMockitoTest {

  @Captor
  private ArgumentCaptor<RepositoryContract.GetSupportListCallback> callbackCaptor;

  @Mock
  private SupportContract.Model modelMock;

  @Mock
  private SupportContract.View viewMock;

  @Mock
  private SupportContract.Router routerMock;

  private SupportContract.Presenter presenter;

  private SupportState supportState;

  @Before
  public void setupSupportScreen() {
    supportState = new SupportState();

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new SupportPresenter(supportState);

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

  @Test
  public void fetchDataAsyncTask() {
    when(routerMock.getDataFromPreviousScreen()).thenReturn(new SupportState());

    List<SupportItem> supportList = new ArrayList<>();
    supportList.add(new SupportItem(1, "", "", "", "", "", "", "", ""));
    supportList.add(new SupportItem(2, "", "", "", "", "", "", "", ""));

    supportState.supportItemList = null;

    presenter.fetchData();

    verify(modelMock).fetchSupportListData(callbackCaptor.capture());
    callbackCaptor.getValue().setSupportList(supportList);


    supportState.supportItemList = supportList;
    supportState.profiles = supportList;

    verify(viewMock).displayData(supportState);
  }

}
