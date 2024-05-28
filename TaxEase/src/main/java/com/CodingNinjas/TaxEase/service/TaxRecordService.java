package com.CodingNinjas.TaxEase.service;

import com.CodingNinjas.TaxEase.dto.TaxRecordDto;
import com.CodingNinjas.TaxEase.model.TaxRecord;
import java.util.List;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import com.CodingNinjas.TaxEase.repository.*;
import com.CodingNinjas.TaxEase.exception.*;
@Service
public class TaxRecordService {

    /*
        This is the service class for TaxRecord, you need to complete the class by doing the following:

            a. Use appropriate annotations.
            b. Complete the methods given below.
            c. Autowire the necessary dependencies.
     */
	@Autowired
	TaxRecordRepository taxRepo;

    // This is the service method for the api which allows user to get a tax Record by sending the record id
    public TaxRecord getTaxRecordById(Long id) {
//    	TaxRecord taxRecord =  taxRepo.getById(id);
//    	if(taxRecord == null) {
//    		throw new TaxRecordNotFoundException("not found");
//    	}
    	return taxRepo.findById(id).orElseThrow(()->new TaxRecordNotFoundException("not found"));
    }


    // This is the service method for the api which allows user fetch all tax Records
    public List<TaxRecord> getAllRecords(Long id) {
    	List<TaxRecord> list =  taxRepo.findAll();
    	if(list == null) {
    		throw new TaxRecordNotFoundException("not found");
    	}
    	return list;
    }


    // This is the service method for the api which allows user to create a tax Record by sending TaxRecordDto as the @ResponseBody
    public void createTaxRecord(TaxRecordDto taxRecordDto) {
    	if(taxRecordDto == null) {
    		throw new TaxRecordNotFoundException("not found");
    	}
    	TaxRecord taxRecord = new TaxRecord();
    	taxRecord.setDeductions(taxRecordDto.getDeductions());
    	taxRecord.setIncome(taxRecordDto.getIncome());
    	taxRecord.setTaxYear(taxRecordDto.getTaxYear());
    	taxRecord.setUserName(taxRecordDto.getUserName());
    	taxRecord.setFilingApproved(false);
    	taxRepo.save(taxRecord);
    }


    // This is the service method for the api which allows user to update a tax Record by sending the record id as a pathVariable and TaxRecordDto as a RequestBody
    public void updateTaxRecord(TaxRecordDto taxRecordDto, Long id) {
    	TaxRecord taxRecord = getTaxRecordById(id);
//    	if(taxRecord == null) {
//    		throw new TaxRecordNotFoundException("data is not found for given id :"+id);
//    	}
    	taxRecord.setDeductions(taxRecordDto.getDeductions());
    	taxRecord.setIncome(taxRecordDto.getIncome());
    	taxRecord.setTaxYear(taxRecordDto.getTaxYear());
    	taxRecord.setUserName(taxRecordDto.getUserName());
    	taxRepo.save(taxRecord);
    }


    // This is the service method for the api which allows user to delete a tax Record by sending the record id as a pathVariable
    public void deleteTaxRecord(Long id) {
    	TaxRecord taxRecord = getTaxRecordById(id);
//    	if(taxRecord == null) {
//    		throw new TaxRecordNotFoundException("not found");
//    	}
    	taxRepo.delete(taxRecord);
    }


    // This is the service method for the api which allows user to fetch all the tax Records by sending the username as a requestParam
    public List<TaxRecord> getRecordsByName(String userName) {
    	List<TaxRecord> list = taxRepo.findByUserName(userName);
    	if(list == null) {
    		throw new TaxRecordNotFoundException("not found");
    	}
    	return list;
    }


    // This is the service method for the api which allows user to approve a tax Record by sending the record id as a pathVariable
    public void approveTaxFiling(Long id) {
    	TaxRecord taxRecord = getTaxRecordById(id);
//    	if(taxRecord == null) {
//    		throw new TaxRecordNotFoundException("not found");
//    	}
    	taxRecord.setFilingApproved(true);
    	taxRepo.save(taxRecord);
    }


    // This is the service method for the api which allows user to reject a tax Record by sending the record id as a pathVariable
    public void rejectTaxFiling(Long id) {
    	TaxRecord taxRecord = getTaxRecordById(id);
//    	if(taxRecord == null) {
//    		throw new TaxRecordNotFoundException("not found");
//    	}
    	taxRecord.setFilingApproved(false);
    	taxRepo.save(taxRecord);
    }
}
