import static org.junit.Assert.*;

import org.junit.Test;

public class RefereeTest {
	
	@Test
	public void DoesAttackHitMissesOnANumberLowerThanDefense() {
		
		Referee referee = new Referee();
		Warcaster AttackingWarcaster = new Warcaster(6, 0, 0, 0, 0, 0, "TestName");
		Warcaster DefendingWarcaster = new Warcaster(0, 14, 0, 0, 0, 0, "TestName");
		Weapon weapon = new Weapon("Test Name", 10, true, false, true);
		Attack attack = new Attack(AttackingWarcaster, weapon, DefendingWarcaster);
		assertFalse(referee.IsAttackASuccess(attack));
	}
	@Test
	public void DoesAttackHitHitsOnANumberHigherThanDefense() {
		
		Referee referee = new Referee();
		Warcaster AttackingWarcaster = new Warcaster(8, 0, 0, 0, 0, 0, "TestName");
		Warcaster DefendingWarcaster = new Warcaster(0, 14, 0, 0, 0, 0, "TestName");
		Weapon weapon = new Weapon("Test Name", 10, true, false, true);
		Attack attack = new Attack(AttackingWarcaster, weapon, DefendingWarcaster);
		assertTrue(referee.IsAttackASuccess(attack));
	}
	@Test
	public void DoesAttackHitHitsOnANumberEqualToTheDefense() {
		
		Referee referee = new Referee();
		Warcaster AttackingWarcaster = new Warcaster(7, 0, 0, 0, 0, 0, "TestName");
		Warcaster DefendingWarcaster = new Warcaster(0, 14, 0, 0, 0, 0, "TestName");
		Weapon weapon = new Weapon("Test Name", 10, true, false, true);
		Attack attack = new Attack(AttackingWarcaster, weapon, DefendingWarcaster);
		assertTrue(referee.IsAttackASuccess(attack));
	}
	@Test
	public void RollDamageDealsDamageOnARollHigherThanArmor() {
		
		Referee referee = new Referee();
		Weapon weapon = new Weapon("TestName", 9, false, false, false);
		Warcaster AttackingWarcaster = new Warcaster(0, 0, 0, 0, 0, 7, "TestName");
		Warcaster DefendingWarcaster = new Warcaster(0, 0, 14, 0, 0, 0, "TestName");
		Attack attack = new Attack(AttackingWarcaster, weapon, DefendingWarcaster);
		assertEquals(9, referee.determineAttackDamage(attack));
	}
	@Test
	public void RollDamageDealsNoDamageOnARollLowerThanArmor() {
		
		Referee referee = new Referee();
		Weapon weapon = new Weapon("TestName", 6, false, false, false);
		Warcaster AttackingWarcaster = new Warcaster(0, 0, 0, 0, 0, 7, "TestName");
		Warcaster DefendingWarcaster = new Warcaster(0, 0, 22, 0, 0, 0, "TestName");
		Attack attack = new Attack(AttackingWarcaster, weapon, DefendingWarcaster);

		assertEquals(0, referee.determineAttackDamage(attack));
	}
	@Test
	public void RollDamageDealsNoDamageOnARollEqualToArmor() {
		
		Referee referee = new Referee();
		Weapon weapon = new Weapon("TestName", 6, false, false, false);
		Warcaster AttackingWarcaster = new Warcaster(0, 0, 0, 0, 0, 7, "TestName");
		Warcaster DefendingWarcaster = new Warcaster(0, 0, 20, 0, 0, 0, "TestName");
		Attack attack = new Attack(AttackingWarcaster, weapon, DefendingWarcaster);

		assertEquals(0, referee.determineAttackDamage(attack));
	}
	@Test
	public void RollDiceReturns7() {
		Referee referee = new Referee();
		assertEquals(7, referee.rollDice());
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