import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class WarcasterTest {

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
	public void TotalAttacksReturnsRemainingFocusPlusNumberOfWeapons() {
		Warcaster warcaster = new Warcaster(0, 0, 0, 7, 0, 0, "TestName");
		warcaster.AddWeapon("TestWeapon", 0, false, false, false);
		assertEquals(8, warcaster.TotalAttacks(warcaster));
	}
	@Test
	public void MakeInitialAttackMakesInitialAttack() {
		Warcaster warcaster = new Warcaster(0, 0, 0, 0, 0, 0, "TestName");
		warcaster.MakeInitalAttack();
		assertTrue(warcaster.GetHasInitialAttackBeenMade());
	}
	@Test
	public void BuyAttackReducesRemainingFocusByOne() {
		Warcaster warcaster = new Warcaster(0, 0, 0, 7, 0, 0, "TestName");
		warcaster.BuyAttack();
		assertEquals(6, warcaster.GetRemainingFocus());
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
}