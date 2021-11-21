/*
 * Copyright(C) 2021,  <FPT UNIVERSITY>.
 * J1.S.P0052
 * Write a program to manage the geographic
 * Record of change:
 * DATE			Version		AUTHOR		DESCRIPTION
 * 2021/9/29     v1			VINH		                   

 */
package j1_S_P0052_Manage_Geographic;

/**
 * @author PHAM KHAC VINH
 *
 */
public class Country {

    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    /**
     * @param countryCode
     * @param countryName
     * @param totalArea
     */
    /**
     * @param countryCode
     * @param countryName
     * @param totalArea2
     */
    protected Country(String countryCode, String countryName, float totalArea2) {
        super();
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea2;
    }

    /**
     *
     */
    protected Country() {
        super();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    

    protected void display() {
        System.out.print(this.countryCode + "\t"
                + this.countryName + "\t"
                + this.totalArea + "\t");
    }

}
