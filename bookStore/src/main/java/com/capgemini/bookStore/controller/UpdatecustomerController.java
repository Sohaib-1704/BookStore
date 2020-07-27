package com.cg.onlinebook.contoller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.book.entity.CustomerInformation;
import com.cg.book.exceptions.UpdatecustomerinformationException;
import com.cg.book.service.IUpdatecustomerservice;



@Component
@RestController
@RequestMapping("/updateprofile")

public class UpdatecustomerController {
	@Autowired
	IUpdatecustomerservice service;
	
	@RequestMapping("/{customerid}")
	public CustomerInformation getbankdetails(@PathVariable int customerid) throws UpdatecustomerinformationException {
		return service.getcustomerdetailbycustomerId(customerid);
		
	}
	@PutMapping("/update/{customerid}/")
	public String updatecustomerinformation(@RequestBody CustomerInformation customer,@PathVariable Integer customerid) throws UpdatecustomerinformationException
	{
		service.updatecustomerinformation(customer,customerid);
		return "Updated";
	}
	
}
