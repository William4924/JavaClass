import static org.junit.Assert.*;

import org.junit.Test;

public class RefereeTest {

	@Test
	public void GetPowerPlusStrengthAddsPowerToStrength() {
		
		Referee referee = new Referee();
		assertEquals(15, referee.GetPowerPlusStrength(8, 7));
	}
	
	@Test
	public void DoesAttackHitMissesOnANumberLowerThanDefense() {
		
		Referee referee = new Referee();
		Warcaster AttackingWarcaster = new Warcaster(6, 0, 0, 0, 0, 0, "TestName");
		Warcaster DefendingWarcaster = new Warcaster(0, 14, 0, 0, 0, 0, "TestName");
		assertFalse(referee.DoesAttackHit(AttackingWarcaster, DefendingWarcaster));
	}
	@Test
	public void DoesAttackHitHitsOnANumberHigherThanDefense() {
		
		Referee referee = new Referee();
		Warcaster AttackingWarcaster = new Warcaster(8, 0, 0, 0, 0, 0, "TestName");
		Warcaster DefendingWarcaster = new Warcaster(0, 14, 0, 0, 0, 0, "TestName");
		assertTrue(referee.DoesAttackHit(AttackingWarcaster, DefendingWarcaster));
	}
	@Test
	public void DoesAttackHitHitsOnANumberEqualToTheDefense() {
		
		Referee referee = new Referee();
		Warcaster AttackingWarcaster = new Warcaster(7, 0, 0, 0, 0, 0, "TestName");
		Warcaster DefendingWarcaster = new Warcaster(0, 14, 0, 0, 0, 0, "TestName");
		assertTrue(referee.DoesAttackHit(AttackingWarcaster, DefendingWarcaster));
	}
	@Test
	public void RollDamageDealsDamageOnARollHigherThanArmor() {
		
		Referee referee = new Referee();
		Weapon weapon = new Weapon("TestName", 9, false, false, false);
		Warcaster AttackingWarcaster = new Warcaster(0, 0, 0, 0, 0, 7, "TestName");
		Warcaster DefendingWarcaster = new Warcaster(0, 0, 14, 0, 0, 0, "TestName");
		assertEquals(9, referee.RollDamage(AttackingWarcaster, DefendingWarcaster, weapon));
	}
	@Test
	public void RollDamageDealsNoDamageOnARollLowerThanArmor() {
		
		Referee referee = new Referee();
		Weapon weapon = new Weapon("TestName", 6, false, false, false);
		Warcaster AttackingWarcaster = new Warcaster(0, 0, 0, 0, 0, 7, "TestName");
		Warcaster DefendingWarcaster = new Warcaster(0, 0, 22, 0, 0, 0, "TestName");
		assertEquals(0, referee.RollDamage(AttackingWarcaster, DefendingWarcaster, weapon));
	}
	@Test
	public void RollDamageDealsNoDamageOnARollEqualToArmor() {
		
		Referee referee = new Referee();
		Weapon weapon = new Weapon("TestName", 6, false, false, false);
		Warcaster AttackingWarcaster = new Warcaster(0, 0, 0, 0, 0, 7, "TestName");
		Warcaster DefendingWarcaster = new Warcaster(0, 0, 20, 0, 0, 0, "TestName");
		assertEquals(0, referee.RollDamage(AttackingWarcaster, DefendingWarcaster, weapon));
	}
}