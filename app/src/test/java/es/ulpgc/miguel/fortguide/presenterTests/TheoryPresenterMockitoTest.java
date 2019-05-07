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
import es.ulpgc.miguel.fortguide.data.TheoryItem;
import es.ulpgc.miguel.fortguide.support.SupportState;
import es.ulpgc.miguel.fortguide.theory.TheoryContract;
import es.ulpgc.miguel.fortguide.theory.TheoryPresenter;
import es.ulpgc.miguel.fortguide.theory.TheoryState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TheoryPresenterMockitoTest {

  @Captor
  private ArgumentCaptor<RepositoryContract.GetTheoryListCallback> callbackCaptor;

  @Mock
  private TheoryContract.Model modelMock;

  @Mock
  private TheoryContract.View viewMock;

  @Mock
  private TheoryContract.Router routerMock;

  private TheoryContract.Presenter presenter;
  private TheoryState theoryState;

  @Before
  public void setupTheoryScreen() {

    theoryState = new TheoryState();

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new TheoryPresenter(theoryState);

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
    TheoryItem theoryItem = new TheoryItem(1,"","","","","");
    presenter.selectTheoryListData(theoryItem);
    verify(routerMock).passDataToTheoryDetailScreen(theoryItem);
    verify(routerMock).navigateToTheoryDetailScreen();
  }

  @Test
  public void goToNewTheoryScreen() {
    presenter.startNewTheoryScreen();
    verify(routerMock).navigateToNewTheoryScreen();
  }

  @Test
  public void fetchDataAsyncTask() {
    when(routerMock.getDataFromPreviousScreen()).thenReturn(new TheoryState());

    List<TheoryItem> theoryList = new ArrayList<>();
    theoryList.add(new TheoryItem(1, "", "", "", "", ""));
    theoryList.add(new TheoryItem(2, "", "", "", "", ""));

    theoryState.theoryItemList = null;

    presenter.fetchData();

    verify(modelMock).fetchTheoryListData(callbackCaptor.capture());
    callbackCaptor.getValue().setTheoryList(theoryList);


    theoryState.theoryItemList = theoryList;

    verify(viewMock).displayData(theoryState);
  }
}
