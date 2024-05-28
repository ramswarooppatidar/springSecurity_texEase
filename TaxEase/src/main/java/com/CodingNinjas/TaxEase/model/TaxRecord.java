package com.CodingNinjas.TaxEase.model;

/*
    This is the entity class, complete this class by doing the following:

    a. Add the required annotations for making this class an entity.
    b. Add the required lombok annotations for getter, setter and constructors
 */
import javax.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="taxrecord")
public class TaxRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column
    private String userName;
	
	@Column
    private String taxYear;
	
	@Column
    private int Income;
	
	@Column
    private int deductions;
	
	@Column
    private boolean isFilingApproved;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getTaxYear() {
//		return taxYear;
//	}
//
//	public void setTaxYear(String taxYear) {
//		this.taxYear = taxYear;
//	}
//
//	public int getIncome() {
//		return Income;
//	}
//
//	public void setIncome(int income) {
//		Income = income;
//	}
//
//	public int getDeductions() {
//		return deductions;
//	}
//
//	public void setDeductions(int deductions) {
//		this.deductions = deductions;
//	}
//
//	public boolean isFilingApproved() {
//		return isFilingApproved;
//	}
//
//	public void setFilingApproved(boolean isFilingApproved) {
//		this.isFilingApproved = isFilingApproved;
//	}
//
//	public TaxRecord(Long id, String userName, String taxYear, int income, int deductions, boolean isFilingApproved) {
//		super();
//		this.id = id;
//		this.userName = userName;
//		this.taxYear = taxYear;
//		Income = income;
//		this.deductions = deductions;
//		this.isFilingApproved = isFilingApproved;
//	}
//
//	public TaxRecord() {
//	}

	
}
