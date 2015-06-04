import static org.junit.Assert.*;

import org.junit.Test;


public class WeaponTests {

	@Test
	public void CreatedWeaponSetsProperties() {
		Weapon weapon = new Weapon("Test Name", 10, true, false, true);
		assertEquals("Test Name", weapon.GetName());
		assertEquals(10, weapon.GetPower());
	}
	@Test
	public void CreatedWeaponSetsIsWeaponMaster() {
		Weapon weapon = new Weapon("Test Name", 10, true, false, false);
		assertTrue(weapon.IsWeaponMaster());
	}
	@Test
	public void CreatedWeaponSetsIsShield() {
		Weapon weapon = new Weapon("Test Name", 10, false, true, false);
		assertTrue(weapon.IsShield());
	}
	@Test
	public void CreatedWeaponSetsIsBuckler() {
		Weapon weapon = new Weapon("Test Name", 10, false, false, true);
		assertTrue(weapon.IsBuckler());
	}
	@Test
	public void CreatedWeaponDefaultsToNotWeaponMaster() {
		Weapon weapon = new Weapon("Test Name", 10, false, false, false);
		assertFalse(weapon.IsWeaponMaster());
	}
	@Test
	public void CreatedWeaponDefaultsToNotShield() {
		Weapon weapon = new Weapon("Test Name", 10, false, false, false);
		assertFalse(weapon.IsShield());
	}
	@Test
	public void CreatedWeaponDefaultsToNotBuckler() {
		Weapon weapon = new Weapon("Test Name", 10, false, false, false);
		assertFalse(weapon.IsBuckler());
	}
}
