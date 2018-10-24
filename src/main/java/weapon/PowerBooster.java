package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class PowerBooster extends Attachment {

  /**
   * Power Boosters increase the base Weapon's damage based on how much ammo is
   * left the more ammo left, the more powerful the boost
   * 
   * @param baseWeapon The weapon to decorate
   * @throws AttachmentException If there are already two attachments
   */
  public PowerBooster(Weapon baseWeapon) throws AttachmentException {
    if (baseWeapon.getNumAttachments() >= 2) {
      throw attachmentCountException;
    }
    base = baseWeapon;
  }

  @Override
  public int fire(int distance) throws WeaponException {
    double multiplier = 1 + ((base.getCurrentAmmo() + 0.0) / base.getMaxAmmo());
    int baseFire = base.fire(distance);
    return (int) (baseFire * multiplier);
  }

  @Override
  public String toString() {
    return base.toString() + " +PowerBooster";
  }
}
