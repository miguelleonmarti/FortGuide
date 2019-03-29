package es.ulpgc.miguel.fortguide.challenge;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.fortguide.data.ChallengeItem;
import es.ulpgc.miguel.fortguide.data.ChallengesWeeksItem;
import es.ulpgc.miguel.fortguide.data.RepositoryContract;

public class ChallengeRepository implements RepositoryContract {

  private static ChallengeRepository INSTANCE;

  private final List<ChallengesWeeksItem> itemList = new ArrayList<>();
  private final int COUNT = 10;

  public static RepositoryContract getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ChallengeRepository();
    }
    return INSTANCE;
  }


  private ChallengeRepository() {
    //Add some objects.
    for (int index = 1; index <= COUNT; index++) {
      addChallenge(createChallenge(index));
    }
  }

  @Override
  public List<ChallengesWeeksItem> getChallengeList() {
    return itemList;
  }


  private void addChallenge(ChallengesWeeksItem item) {
    itemList.add(item);
  }

  private void addChallenge(List<ChallengeItem> itemList, ChallengeItem item) {
    itemList.add(item);
  }


  private ChallengeItem createChallenge(int id, int position) {
    String content = "Desafio" + id + "." + position;

    return new ChallengeItem(
        position, content, fetchChallengeDetails(id, position)
    );
  }

  private ChallengesWeeksItem createChallenge(int position) {
    String content = "Semana " + position;

    return new ChallengesWeeksItem(
        position, content);
  }

  private String fetchChallengeDetails(int id, int position) {
    String content = "Dificultad" + "." + position;
    StringBuilder builder = new StringBuilder();
    builder.append(content);

    for (int index = 0; index < position; index++) {
      builder.append("\nMore details");
    }
    return builder.toString();
  }

  // TODO: ELIMINAR
  @Override
  public void loadSupport(FetchSupportDataCallback callback) {

  }

  @Override
  public void getSupportList(GetSupportListCallback callback) {

  }

  @Override
  public void getSupportItem(int id, GetSupportItemCallback callback) {

  }
}

