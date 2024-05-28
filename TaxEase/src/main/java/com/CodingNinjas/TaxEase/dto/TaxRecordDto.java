package com.CodingNinjas.TaxEase.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxRecordDto {

    /* This is the taxRecord Dto class, and you need to complete the class by doing the following:

     a. Add the following attributes:

         String userName
         String taxYear
         int Income
         int deductions

     b. Use lombok annotations for getter, setters and constructors
     */
	 String userName;
     String taxYear;
     int Income;
     int deductions;
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public String getTaxYear() {
//		return taxYear;
//	}
//	public void setTaxYear(String taxYear) {
//		this.taxYear = taxYear;
//	}
//	public int getIncome() {
//		return Income;
//	}
//	public void setIncome(int income) {
//		Income = income;
//	}
//	public int getDeductions() {
//		return deductions;
//	}
//	public void setDeductions(int deductions) {
//		this.deductions = deductions;
//	}
//	public TaxRecordDto(String userName, String taxYear, int income, int deductions) {
//		super();
//		this.userName = userName;
//		this.taxYear = taxYear;
//		Income = income;
//		this.deductions = deductions;
//	}
//    public TaxRecordDto() {
//    	
//    }

}
