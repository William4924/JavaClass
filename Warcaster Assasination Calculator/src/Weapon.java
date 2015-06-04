public class Weapon {

	private int m_Power;
	private String m_Name;
	private boolean m_isWeaponMaster;
	private boolean m_isShield;
	private boolean m_isBuckler;
	
	public Weapon(String aName, int aPower, boolean aIsWeaponMaster, 
			boolean aIsShield, boolean aIsBuckler) {
		m_Name = aName;
		m_Power = aPower;
		m_isWeaponMaster = aIsWeaponMaster;
		m_isShield = aIsShield;
		m_isBuckler = aIsBuckler;
	}
	public String GetName() {
		return m_Name;
	}
	public int GetPower() {
		return m_Power;
	}
	public boolean IsWeaponMaster() {
		return m_isWeaponMaster;
	}
	public boolean IsShield() {
		return m_isShield;
	}
	public boolean IsBuckler() {
		return m_isBuckler;
	}
}