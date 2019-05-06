package es.ulpgc.miguel.fortguide;

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

import es.ulpgc.miguel.fortguide.advice.AdviceContract;
import es.ulpgc.miguel.fortguide.advice.AdvicePresenter;
import es.ulpgc.miguel.fortguide.advice.AdviceState;
import es.ulpgc.miguel.fortguide.data.AdviceItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.SupportItem;
import es.ulpgc.miguel.fortguide.support.SupportState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class AdvicePresenterMockitoTest {

  @Captor
  private ArgumentCaptor<RepositoryContract.GetAdviceListCallback> callbackCaptor;

  @Mock
  private AdviceContract.Model modelMock;

  @Mock
  private AdviceContract.View viewMock;

  @Mock
  private AdviceContract.Router routerMock;

  private AdviceContract.Presenter presenter;
  private AdviceState adviceState;

  @Before
  public void setupAdviceScreen() {

    adviceState = new AdviceState();

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new AdvicePresenter(adviceState);

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
  public void goToAdviceDetailScreen() {
    AdviceItem adviceItem = new AdviceItem(1,"","");
    presenter.selectAdviceListData(adviceItem);
    verify(routerMock).passDataToAdviceDetailScreen(adviceItem);
    verify(routerMock).navigateToAdviceDetailScreen();
  }

  @Test
  public void fetchDataAsyncTask() {
    when(routerMock.getDataFromPreviousScreen()).thenReturn(new AdviceState());

    List<AdviceItem> adviceList = new ArrayList<>();
    adviceList.add(new AdviceItem(1,"",""));
    adviceList.add(new AdviceItem(2,"",""));

    adviceState.adviceItemList = null;

    presenter.fetchData();

    verify(modelMock).fetchAdviceListData(callbackCaptor.capture());
    callbackCaptor.getValue().setAdviceList(adviceList);

    adviceState.adviceItemList = adviceList;

    verify(viewMock).displayData(adviceState);
  }
}
