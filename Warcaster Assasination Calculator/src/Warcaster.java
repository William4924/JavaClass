import java.util.ArrayList;

public class Warcaster {
	
	private int MAT;
	private int Defense;
	private int Armor;
	private int MagicAbility;
	private int MaxBoxes;
	private int RemainingFocus;
	private int RemainingBoxes;
	private int Strength;
	private String Name;
	private ArrayList<Weapon> WeaponList = new ArrayList<Weapon>();
	private Boolean HasInitialAttackBeenMade = false;

	
	public Warcaster(int aMAT, int aDefense, int aArmor, int aMagicAbility, 
			int aMaxBoxes, int aStrength, String aName) {
		MAT = aMAT;
		Defense = aDefense;
		Armor = aArmor;
		MagicAbility = aMagicAbility;
		RemainingFocus = MagicAbility;
		MaxBoxes = aMaxBoxes;
		RemainingBoxes = MaxBoxes;
		Strength = aStrength;
		Name = aName;
	}
	
	public int TakeDamage(int DamageToTake) {
		RemainingBoxes -= DamageToTake;
		return RemainingBoxes;
	}
	
	public boolean IsBoxed() {
		
		return (RemainingBoxes <= 0);
	}
	public int GetMAT() { return MAT; }
	public int GetDefense() { return Defense; }
	public int GetArmor() { return Armor; }
	public int GetMagicAbility() { return MagicAbility; }
	public int GetMaxBoxes() { return MaxBoxes; }
	public int GetRemainingFocus() { return RemainingFocus; }
	public int GetRemainingBoxes() { return RemainingBoxes;	}
	public int GetStrength() { return Strength; }
	public ArrayList<Weapon> GetWeapons() { return WeaponList; }
	public boolean GetHasInitialAttackBeenMade() { return HasInitialAttackBeenMade; }
	
	public void AddWeapon(String Name, int Power, boolean IsWeaponMaster, 
			boolean IsShield, boolean IsBuckler) {
		Weapon weapon = new Weapon(Name, Power, IsWeaponMaster, IsShield, IsBuckler);
	    WeaponList.add(weapon);
	}
	
	public int TotalAttacks(Warcaster warcaster) {
		
		return warcaster.GetRemainingFocus() + warcaster.GetWeapons().size();
	}
	
	public void MakeInitalAttack() {
		
		HasInitialAttackBeenMade = true;
	}
	
	public void BuyAttack() {
		
		RemainingFocus--;
	}
	
	public boolean IsAbleToBuyAttack() {
		
		return (RemainingFocus > 0);
	}
}