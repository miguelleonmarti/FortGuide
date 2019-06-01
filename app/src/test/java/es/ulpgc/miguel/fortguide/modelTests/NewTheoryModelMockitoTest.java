package es.ulpgc.miguel.fortguide.modelTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.TheoryItem;
import es.ulpgc.miguel.fortguide.newTheory.NewTheoryContract;
import es.ulpgc.miguel.fortguide.newTheory.NewTheoryModel;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NewTheoryModelMockitoTest {

  @Mock
  private RepositoryContract repositoryMock;

  private NewTheoryContract.Model model;

  private RepositoryContract.InsertTheoryCallback callback = new RepositoryContract.InsertTheoryCallback() {
    @Override
    public void theoryInserted() {

    }
  };

  private static final String nameTheory = "";
  private static final String user = "";
  private static final String description = "";
  private static final TheoryItem item = new TheoryItem(0, nameTheory, description, user, "0", "0");

  @Before
  public void setupSupportScreen() {
    model = new NewTheoryModel(repositoryMock);
  }

  /*@Test
  public void insertTheory() {
    model.insertTheory("","","",callback);
    verify(repositoryMock).insertTheory(new TheoryItem(0, "","","","0","0"), callback);

    //model.fetchTheoryListData(callback);
    //verify(repositoryMock).loadTheory(eq(clearFirst), callbackCaptor.capture());
    //callbackCaptor.getValue().onTheoryDataFetched(error);
    //verify(repositoryMock).getTheoryList(callback);
  }*/

  /*
    @Override
  public void insertTheory(String user, String nameTheory, String description, RepositoryContract.InsertTheoryCallback callback){
    TheoryItem theory = new TheoryItem(0, nameTheory, description, user, "0","0");
    repository.insertTheory(theory, callback);
  }
   */
}
