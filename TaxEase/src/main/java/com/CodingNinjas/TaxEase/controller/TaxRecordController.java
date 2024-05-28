package com.CodingNinjas.TaxEase.controller;

import com.CodingNinjas.TaxEase.dto.TaxRecordDto;
import com.CodingNinjas.TaxEase.model.TaxRecord;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.CodingNinjas.TaxEase.service.*;
import com.CodingNinjas.TaxEase.model.*;
import org.springframework.beans.factory.annotation.*;

import org.springframework.security.access.prepost.*;
@RestController
@RequestMapping("/api/tax")
public class TaxRecordController {

    /*
        This is the controller class for TaxRecord, you need to complete the class by doing the following:
        a. Use appropriate annotations.
        b. Based on the endpoints mentioned in the problem statement complete the methods given below.
        c. Autowire the necessary dependencies.
    */

	@Autowired
	TaxRecordService taxRecordService;


    //  1. API: GET "/api/tax/{id}": This api allows user to get a tax Record by sending the record id.
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('NORMAL')")
    public TaxRecord getTaxRecordById(@PathVariable Long id){
        return taxRecordService.getTaxRecordById(id);
    }


    // 2. API: GET "/api/tax/all": This api allows user to fetch all the list of tax Records from the database.
    @GetMapping("/all")
    @PreAuthorize("hasRole('NORMAL')")
    public List<TaxRecord> getALlTaxRecords(){
        return taxRecordService.getAllRecords(null);
    }


    // 3. API: POST "/api/tax": This api allows user to create a tax Record by sending TaxRecordDto as the @ResponseBody.
    @PostMapping
    @PreAuthorize("hasRole('NORMAL')")
    public void createTaxRecord(@RequestBody TaxRecordDto taxRecordDto){
    	taxRecordService.createTaxRecord(taxRecordDto);
    }


    // 4. API: PUT "/api/tax/{id}": This api allows user to update a tax Record by sending the record id as a pathVariable and TaxRecordDto as a RequestBody.
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('NORMAL')")
    public void updateTaxRecord(@RequestBody TaxRecordDto taxRecordDto, @PathVariable Long id){
    	taxRecordService.updateTaxRecord(taxRecordDto, id);
    }


    // 5. API: DELETE "/api/tax/{id}": This api allows user to delete a tax Record by sending the record id as a pathVariable.
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('NORMAL')")
    public void deleteTaxRecord(@PathVariable Long id){
    	taxRecordService.deleteTaxRecord(id);
    }


    // 6. API: GET "/api/tax": This api allows user to fetch all the tax Records by sending the username as a requestParam.
    @GetMapping
    @PreAuthorize("hasRole('NORMAL')")
    public List<TaxRecord> getTaxRecordsByUserName(@RequestParam String userName){
        return taxRecordService.getRecordsByName(userName);
    }



    // 7. API: POST "/api/tax/approve/{id}": This api allows user to approve a tax Record by sending the record id as a pathVariable.
    @PostMapping("/approve/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void approveTaxFiling(@PathVariable Long id){
    	taxRecordService.approveTaxFiling(id);
    }


    // 8. API: POST "/api/tax/reject/{id}": This api allows user to reject a tax Record by sending the record id as a pathVariable.
    @PostMapping("/reject/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void rejectTaxFiling(@PathVariable Long id){
    	taxRecordService.rejectTaxFiling(id);
    }


}
