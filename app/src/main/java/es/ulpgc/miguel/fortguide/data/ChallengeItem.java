package es.ulpgc.miguel.fortguide.data;

public class ChallengeItem extends Item{

  private int weeksId;

public ChallengeItem(int id,String content,String details,int weeksId){
  super(id, content, details);
  this.weeksId = weeksId;
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

  public int getWeeksId() {
    return weeksId;
  }

  public void setWeeksId(int weeksId) {
    this.weeksId = weeksId;
  }
}
