/*
 * Copyright(C) 2021,  <FPT UNIVERSITY>.
 * J1.S.P0052
 * Write a program to manage the geographic
 * Record of change:
 * DATE			Version		AUTHOR		DESCRIPTION
 * 2021/9/29     v1			VINH		                   

*/

/**
 * 
 */
package j1_S_P0052_Manage_Geographic;

public class EastAsiaCountries extends Country {
	private String countryTerrain;

	/**
	 * 
	 */
	protected EastAsiaCountries() {
		super();

	}

	/**
	 * @param countryCode
	 * @param countryName
	 * @param totalArea
	 * @param countryTerrain
	 */
	protected EastAsiaCountries(String countryCode, String countryName,
                float totalArea, String countryTerrain) {
		super(countryCode, countryName, totalArea);
		this.countryTerrain = countryTerrain;

	}

	public String getCountryTerrain() {
		return countryTerrain;
	}

	public void setCountryTerrain(String countryTerrain) {
		this.countryTerrain = countryTerrain;
	}

	@Override
	protected void display() {
		System.out.format("%-10s%-25s%-20s%-25s\n", this.countryCode,
                this.countryName, this.totalArea, this.countryTerrain);
	}

}
