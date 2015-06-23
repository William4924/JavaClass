public class Referee {
	
	public Boolean IsAttackASuccess(Attack attack) {
		
		if (attack.getAttacker().GetMAT() + rollDice() >= attack.getDefender().GetDefense()) {
			return true;
		} else {
			return false;
		}
	}
	
	public int determineAttackDamage(Attack attack) {
		
		int DifferenceBetweenDamageRollAndArmor = attack.PowerPlusStrength() + rollDice() - attack.getDefender().GetArmor();
		if (DifferenceBetweenDamageRollAndArmor > 0) {
			
			return DifferenceBetweenDamageRollAndArmor;
		} else {
			return 0;
		}
	}
	
	public int rollDice() {
		
		return 7;
	}
	
	public void askWarcasterWhatToDo(Warcaster warcaster, Warcaster defender) {
		
		if (warcaster.GetHasInitialAttackBeenMade() == false) {
			warcaster.makeInitialAttack(defender);
		}
		if (warcaster.GetHasInitialAttackBeenMade() == true) {
			warcaster.BuyAttack(defender);
		}
	}
}