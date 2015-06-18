import static org.junit.Assert.*;

import org.junit.Test;

public class AttackTests {

	private Attack TestAttack() {
		Warcaster attacker = new Warcaster(5, 12, 14, 6, 18, 12, "Testo");
		Warcaster defender = new Warcaster(5, 12, 14, 6, 18, 12, "Defendo");
		Weapon weapon = new Weapon("Sword", 5, false, false, false);
		attacker.AddWeapon("Sword", 5, false, false, false);
		Attack attack = new Attack(attacker, weapon, defender);
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
		assertEquals("Testo", attack.getAttacker().GetName());
	}
	@Test
	public void PowerPlusStrengthOfTestoEquals17() {
		Attack attack = TestAttack();
		assertEquals(17, attack.PowerPlusStrength());
	}
	@Test
	public void CreatingAnAttackCausesGetDefenderToReturnSameDefender() {
		Attack attack = TestAttack();
		assertEquals("Defendo", attack.getDefender().GetName());
	}
}