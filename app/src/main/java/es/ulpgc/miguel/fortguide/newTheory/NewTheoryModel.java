package es.ulpgc.miguel.fortguide.newTheory;

import es.ulpgc.miguel.fortguide.data.RepositoryContract;
import es.ulpgc.miguel.fortguide.data.TheoryItem;

public class NewTheoryModel implements NewTheoryContract.Model {

  public static String TAG = NewTheoryModel.class.getSimpleName();
  private RepositoryContract repository;

  public NewTheoryModel(RepositoryContract repository) {
    this.repository=repository;
  }

  @Override
  public void insertTheory(String user, String nameTheory, String description, RepositoryContract.InsertTheoryCallback callback){
    //TheoryItem theory = new TheoryItem(0, nameTheory, description, user, "0","0");
    repository.insertTheory(new TheoryItem(0, nameTheory, description, user, "0","0"), callback);
  }
}
