import static org.junit.Assert.*;

import org.junit.Test;

public class AttackTests {

	private Attack TestAttack() {
		Warcaster warcaster = new Warcaster(5, 12, 14, 6, 18, 12, "Testo");
		Weapon weapon = new Weapon("Sword", 5, false, false, false);
		warcaster.AddWeapon("Sword", 5, false, false, false);
		Attack attack = new Attack(warcaster, weapon);
		return attack;
	}
	@Test
	public void CreatingAnAttackCausesGetWeaponToReturnSameWeapon() {
		Attack attack = TestAttack();
		assertEquals("Sword", attack.GetWeapon().GetName());
	}
	@Test
	public void CreatingAnAttackCausesGetWarcasterToReturnSameWarcaster() {
		Attack attack = TestAttack();
		assertEquals("Testo", attack.GetWarcaster().GetName());
	}
	@Test
	public void PowerPlusStrengthOfTestoEquals17() {
		Attack attack = TestAttack();
		assertEquals(17, attack.PowerPlusStrength());
	}
}