package es.ulpgc.miguel.fortguide.modelTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import es.ulpgc.miguel.fortguide.challenges_weeks.ChallengesWeeksListContract;
import es.ulpgc.miguel.fortguide.challenges_weeks.ChallengesWeeksListModel;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ChallengesWeeksListModelMockitoTest {

  @Captor
  private ArgumentCaptor<RepositoryContract.FetchWeeksDataCallback> callbackCaptor;

  @Mock
  private RepositoryContract repositoryMock;

  private ChallengesWeeksListContract.Model model;

  private RepositoryContract.GetWeeksListCallback callback = new RepositoryContract.GetWeeksListCallback() {
    @Override
    public void setWeeksItemList(List<ChallengesWeeksItem> WeeksList) {

    }
  };

  private static final boolean clearFirst = true;
  private static final boolean error = false;

  @Before
  public void setupChallengesWeeksListScreen() {
    model = new ChallengesWeeksListModel(repositoryMock);
  }

  @Test
  public void fetchDataAsyncTask() {
    model.fetchWeeksListData(callback);
    verify(repositoryMock).loadWeeks(eq(clearFirst), callbackCaptor.capture());
    callbackCaptor.getValue().onWeeksDataFetched(error);
    verify(repositoryMock).getWeeksList(callback);
  }
}
