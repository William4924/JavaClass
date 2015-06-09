public class Referee {
	
	public Boolean IsAttackASuccess(Warcaster attacker, Warcaster defender) {
		
		if (attacker.GetMAT() + 7 >= defender.GetDefense()) {
			return true;
		} else {
			return false;
		}
	}
	
	public int GetAttackDamage(Warcaster attacker, Warcaster defender, Weapon weapon) {
		
		Attack attack = new Attack(attacker, weapon);
		int DifferenceBetweenDamageRollAndArmor = attack.PowerPlusStrength() + 7 - defender.GetArmor();
		if (DifferenceBetweenDamageRollAndArmor > 0) {
			
			return DifferenceBetweenDamageRollAndArmor;
		} else {
			return 0;
		}
	}
}