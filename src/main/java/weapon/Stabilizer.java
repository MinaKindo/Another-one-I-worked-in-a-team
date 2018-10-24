package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class Stabilizer extends Attachment {

  /**
   * Creates an instance of a Stabilizer wrapped around a base GenericWeapon
   * Scopes. Provides a 25% damage multiplier and auto-reloading.
   * 
   * @param baseWeapon The weapon to decorate
   * @throws AttachmentException If there are already two attachments
   */
  public Stabilizer(Weapon baseWeapon) throws AttachmentException {
    if (baseWeapon.getNumAttachments() >= 2) {
      throw attachmentCountException;
    }
    base = baseWeapon;
  }

  @Override
  public int fire(int distance) throws WeaponException {
    int damage = (int) Math.floor(Double.valueOf(base.fire(distance) * 1.25));
    if (this.getCurrentAmmo() == 0) {
      base.reload();
    }
    return damage;
  }

  @Override
  public String toString() {
    return base.toString() + " +Stabilizer";
  }
}
