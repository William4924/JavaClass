public class Referee {

	public int GetPowerPlusStrength(int Power, int Strength) {
		
		return Power + Strength;
	}
	
	public Boolean DoesAttackHit(Warcaster AttackingWarcaster, Warcaster DefendingWarcaster) {
		
		if (AttackingWarcaster.GetMAT() + 7 >= DefendingWarcaster.GetDefense()) {
			return true;
		} else {
			return false;
		}
	}
	
	public int RollDamage(Warcaster AttackingWarcaster, Warcaster DefendingWarcaster, Weapon weapon) {
		
		Referee referee = new Referee();
		int DifferenceBetweenDamageRollAndArmor = referee.GetPowerPlusStrength(weapon.GetPower(), 
				AttackingWarcaster.GetStrength()) + 7 - DefendingWarcaster.GetArmor();
		if (DifferenceBetweenDamageRollAndArmor > 0) {
			
			return DifferenceBetweenDamageRollAndArmor;
		} else {
			return 0;
		}
	}
}