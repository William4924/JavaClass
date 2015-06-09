public class Attack {

	private Weapon currentWeapon;
	private Warcaster currentWarcaster;
	
	public Attack(Warcaster attacker, Weapon weapon) {
		
		currentWeapon = weapon;
		currentWarcaster = attacker;
	}

	public Weapon GetWeapon() {
		
		return currentWeapon;
	}

	public Warcaster GetWarcaster() {
		
		return currentWarcaster;
	}
	
	public int PowerPlusStrength() {
		
		return currentWeapon.GetPower() + currentWarcaster.GetStrength();
	}
}