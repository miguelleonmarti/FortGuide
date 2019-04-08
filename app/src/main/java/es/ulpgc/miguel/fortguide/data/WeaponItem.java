package es.ulpgc.miguel.fortguide.data;

public class WeaponItem {

  private final String id, name, rarity, image, damageBody, damageHead, dps, fireRate, reload, size, ammo;

  public WeaponItem(String id, String name, String rarity, String image, String damageBody,
                    String damageHead, String dps, String fireRate, String reload, String size, String ammo) {
    this.id = id;
    this.name = name;
    this.rarity = rarity;
    this.image = image;
    this.damageBody = damageBody;
    this.damageHead = damageHead;
    this.dps = dps;
    this.fireRate = fireRate;
    this.reload = reload;
    this.size = size;
    this.ammo = ammo;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getRarity() {
    return rarity;
  }

  public String getImage() {
    return image;
  }

  public String getDamageBody() {
    return damageBody;
  }

  public String getDamageHead() {
    return damageHead;
  }

  public String getDps() {
    return dps;
  }

  public String getFireRate() {
    return fireRate;
  }

  public String getReload() {
    return reload;
  }

  public String getSize() {
    return size;
  }

  public String getAmmo() {
    return ammo;
  }
}
