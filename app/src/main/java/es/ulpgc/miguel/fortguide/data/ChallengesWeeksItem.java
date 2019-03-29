package es.ulpgc.miguel.fortguide.data;

import java.util.ArrayList;
import java.util.List;

public class ChallengesWeeksItem extends ChallengeAbstract {

  public final List<ChallengesWeeksItem> items;



  public ChallengesWeeksItem(int id, String content) {  // Contructor de la clase Challenge.
    super(id, content);
    items = new ArrayList<>(); //Creamos un nuevo arrayList de desafios.
  }

  @Override
  public String toString() {
    return super.toString();
  }
}

