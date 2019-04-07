package es.ulpgc.miguel.fortguide.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChallengesWeeksItem extends Item {

  @SerializedName("detail")
  private final List<ChallengeItem> items;

  public ChallengesWeeksItem(int id, String content, String details, List<ChallengeItem> items) {
    super(id, content, details);
    this.items = items;
  }

  @Override
  public int getId() {
    return super.getId();
  }

  @Override
  public String getContent() {
    return super.getContent();
  }

  @Override
  public String getDetails() {
    return super.getDetails();
  }

  public List<ChallengeItem> getItems() {
    return items;
  }
}

