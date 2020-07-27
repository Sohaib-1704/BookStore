package com.cg.onlinebook.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.book.entity.CustomerInformation;
import com.cg.book.exceptions.CustomerEmailIdnotFound;
import com.cg.book.exceptions.CustomerException;
import com.cg.book.exceptions.CustomerIdNotFoundException;
import com.cg.book.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService ser;
	/************************************************************************************
	 * Method: ViewCustomer
     * Description: To Fetch the customer Information by customer ID.
     * Created By                     - Nishant Shrivastav
     * Created Date                   - 16-JULY-2020                           
	 ************************************************************************************/

	@GetMapping("/viewcustomer/{customerId}")
	public CustomerInformation viewCustomer(HttpServletRequest req, @PathVariable("customerId") String customerId)
			throws CustomerException, CustomerIdNotFoundException {

		
		return ser.viewCustomer(customerId);

	}

	@GetMapping("/viewByEmail/{email}")
	public CustomerInformation viewCustomerByEmail(HttpServletRequest req, @PathVariable("email") String email)
			throws CustomerException, CustomerEmailIdnotFound {

		return ser.viewByEmailId(email);
		
	}

}

