package es.ulpgc.miguel.fortguide.data;

import java.util.ArrayList;
import java.util.List;

public class ChallengeItem extends ChallengeAbstract {

  public final List<ChallengeItem> items;
  public final String details;


  public ChallengeItem(int id, String content, String details) {  // Contructor de la clase Challenge.
    super(id, content);
    items = new ArrayList<>(); //Creamos un nuevo arrayList de desafios.
    this.details = details;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}

