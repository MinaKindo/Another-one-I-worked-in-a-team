
package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class Scope extends Attachment {

  /**
   * Creates an instance of a Scope wrapped around a base GenericWeapon Scopes add
   * 10 to the maxRange of the base Weapon
   * 
   * @param baseWeapon The weapon to decorate
   * @throws AttachmentException If there are already two attachments
   */
  public Scope(Weapon baseWeapon) throws AttachmentException {
    if (baseWeapon.getNumAttachments() >= 2) {
      throw attachmentCountException;
    }
    base = baseWeapon;
  }

  @Override
  public int fire(int distance) throws WeaponException {
    if (base.getMaxRange() < distance && distance <= base.getMaxRange() + 10) {
      return base.fire(base.getMaxRange()) + 5;
    } else {
      return (int) (base.fire(distance)
          * (1 + ((base.getMaxRange() + 10) - distance + 0.0) / (base.getMaxRange() + 10)));
    }
  }

  @Override
  public int getMaxRange() {
    return base.getMaxRange() + 10;
  }

  @Override
  public String toString() {
    return base.toString() + " +Scope";
  }
}
