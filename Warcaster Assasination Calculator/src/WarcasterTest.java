import static org.junit.Assert.*;

import org.junit.Test;

public class WarcasterTest {

	private Warcaster testAttacker(int MAT, int strength, int magic) {
		return new Warcaster(MAT, 0, 0, magic, 1, strength, "Attacko");
	}
	private Warcaster testDefender(int defense, int armor, int maxboxes) {
		return new Warcaster(0, defense, armor, 0, maxboxes, 0, "Defendo");
	}
	
	@Test
	public void TakeDamageReducesBoxesRemaining() {
		Warcaster warcaster = new Warcaster(0, 0, 0, 0, 10, 0, "TestName");
		warcaster.TakeDamage(3);
		assertEquals(7, warcaster.GetRemainingBoxes());
	}
	
	@Test
	public void IsBoxedIsTrueWhen0OrFewerBoxes() {
		Warcaster warcaster = new Warcaster(0, 0, 0, 0, 0, 0, "TestName");
		assertTrue(warcaster.IsBoxed());
	}
	@Test
	public void IsNotBoxedWhen1OrMoreBoxesRemain() {
		Warcaster warcaster = new Warcaster(0, 0, 0, 0, 1, 0, "TestName");
		assertFalse(warcaster.IsBoxed());
	}
	@Test
	public void AddWeaponAddsNewWeapon() {
		String TestWeapon = ("TestWeapon");
		Warcaster warcaster = new Warcaster(0, 0, 0, 0, 0, 0, "TestName");
		warcaster.AddWeapon(TestWeapon, 15, false, true, false);
		assertEquals(1, warcaster.GetWeapons().size());
		assertEquals("TestWeapon", warcaster.GetWeapons().get(0).GetName());
	}
	@Test
	public void MakeInitialAttackMakesInitialAttack() {
		Warcaster warcaster = new Warcaster(0, 0, 0, 0, 0, 0, "TestName");
		warcaster.AddWeapon("Sword", 8, false, false, false);
		warcaster.makeInitialAttack(testDefender(11, 14, 18));
		assertTrue(warcaster.GetHasInitialAttackBeenMade());
	}
	@Test
	public void BuyAttackReducesRemainingFocusByOne() {
		Warcaster defender = testDefender(11, 14, 18);
		Warcaster attacker = testAttacker(5, 4, 7);
		attacker.AddWeapon("Sword", 5, false, false, false);
		attacker.BuyAttack(defender);
		assertEquals(6, attacker.GetRemainingFocus());
	}
	@Test
	public void IsAbleToBuyAttackIsFalseWhenRemainingFocusIs0() {
		Warcaster warcaster = new Warcaster(0, 0, 0, 0, 0, 0, "TestName");
		assertFalse(warcaster.IsAbleToBuyAttack());
	}
	@Test
	public void IsAbleToBuyAttackIsTrueWhenRemainingFocusIs1() {
		Warcaster warcaster = new Warcaster(0, 0, 0, 1, 0, 0, "TestName");
		assertTrue(warcaster.IsAbleToBuyAttack());
	}
	@Test
	public void MakeInitialAttackShouldCreateAnAttackWithFirstWeapon() {
		Warcaster attacker = testAttacker(5, 4, 6);
		attacker.AddWeapon("Sword", 5, false, false, false);
		Warcaster defender = testDefender(11, 14, 18);
		Attack attack = attacker.makeInitialAttack(defender);
		assertEquals("Sword", attack.GetWeapon().GetName());
	}
	@Test
	public void BuyAttackShouldCreateAnAttackWithFirstWeapon() {
		Warcaster attacker = testAttacker(5, 4, 6);
		attacker.AddWeapon("Sword", 5, false, false, false);
		Warcaster defender = testDefender(11, 14, 18);
		Attack attack = attacker.BuyAttack(defender);
		assertEquals("Sword", attack.GetWeapon().GetName());
	}
	@Test
	public void askWarcasterWhatToDoRunsInitialAttackWhenHasInitialAttackBeenMadeIsFalse() {
		
		Referee referee = new Referee();
		Warcaster attacker = new Warcaster(0, 0, 0, 0, 0, 0, "TestName");
		Warcaster defender = new Warcaster(0, 0, 0, 0, 0, 0, "TestName");
		attacker.AddWeapon("Sword", 8, false, false, false);
		referee.askWarcasterWhatToDo(attacker, defender);
		assertTrue(attacker.GetHasInitialAttackBeenMade());
	}
	@Test
	public void askWarcasterWhatToDoRunsBuyAttackWhenHasInitialAttackBeenMadeIsTrue() {
		
		Referee referee = new Referee();
		Warcaster attacker = new Warcaster(0, 0, 0, 7, 0, 0, "TestName");
		Warcaster defender = new Warcaster(0, 0, 0, 0, 0, 0, "TestName");
		attacker.AddWeapon("Sword", 8, false, false, false);
		referee.askWarcasterWhatToDo(attacker, defender);
		assertEquals(0, attacker.GetRemainingFocus());
	}
}