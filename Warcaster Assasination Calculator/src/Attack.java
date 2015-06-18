public class Attack {

	private Weapon currentWeapon;
	private Warcaster currentAttacker;
	private Warcaster currentDefender;
	
	public Attack(Warcaster attacker, Weapon weapon, Warcaster defender) {
		
		currentWeapon = weapon;
		currentAttacker = attacker;
		currentDefender = defender;
	}

	public Weapon GetWeapon() {
		
		return currentWeapon;
	}

	public Warcaster getAttacker() {
		
		return currentAttacker;
	}
	
	public Warcaster getDefender() {
		
		return currentDefender;
	}
	
	public int PowerPlusStrength() {
		
		return currentWeapon.GetPower() + currentAttacker.GetStrength();
	}
}