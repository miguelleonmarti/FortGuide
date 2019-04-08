package es.ulpgc.miguel.fortguide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;
import java.util.List;


import es.ulpgc.miguel.fortguide.challenges_weeks.ChallengesWeeksListContract;
import es.ulpgc.miguel.fortguide.challenges_weeks.ChallengesWeeksListPresenter;
import es.ulpgc.miguel.fortguide.challenges_weeks.ChallengesWeeksListState;
import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChallengesWeeksPresenterMockitoTest {


  @Mock
  private ChallengesWeeksListContract.Model modelMock;

  @Mock
  private ChallengesWeeksListContract.View viewMock;

  @Mock
  private ChallengesWeeksListContract.Router routerMock;

  private ChallengesWeeksListContract.Presenter presenter;

  @Before
  public void setupIntroductionScreen() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    presenter = new ChallengesWeeksListPresenter(new ChallengesWeeksListState());

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
  public void goToChallengeDetailListScreen(){
    List<ChallengeItem> challengeItemList = null;
    ChallengesWeeksItem challengesWeeksItem = new ChallengesWeeksItem(1,"","",challengeItemList);
    presenter.selectWeeksListData(challengesWeeksItem);
    verify(routerMock).passDataToChallengeDetailsScreen(challengesWeeksItem);
    verify(routerMock).navigateToChallengeDetailsScreen();
  }


  //TODO Faltan metodos que testear
}

