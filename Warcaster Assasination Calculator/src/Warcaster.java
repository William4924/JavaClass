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
	public String GetName() { return Name; }
	public ArrayList<Weapon> GetWeapons() { return WeaponList; }
	public boolean GetHasInitialAttackBeenMade() { return HasInitialAttackBeenMade; }
	
	public void AddWeapon(String Name, int Power, boolean IsWeaponMaster, 
			boolean IsShield, boolean IsBuckler) {
		Weapon weapon = new Weapon(Name, Power, IsWeaponMaster, IsShield, IsBuckler);
	    WeaponList.add(weapon);
	}
	
	public Attack makeInitialAttack(Warcaster defender) {
		
		Attack attack = new Attack(this, GetWeapons().get(0), defender);
		HasInitialAttackBeenMade = true;
		return attack;
	}
	
	public Attack BuyAttack(Warcaster defender) {
		
		Attack attack = new Attack(this, GetWeapons().get(0), defender);
		RemainingFocus--;
		return attack;
	}
	
	public boolean IsAbleToBuyAttack() {
		
		return (RemainingFocus > 0);
	}
	
	public void DetermineWhatAttackToUse(Warcaster defender) {
		
		if (HasInitialAttackBeenMade == false) {
			
			this.makeInitialAttack(defender);
		}
		
		while (RemainingFocus > 0) {
			
			this.BuyAttack(defender);
		}
	}
}