package com.in2itebs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in2itebs.demo.entities.Address;
import com.in2itebs.demo.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressSrv;
	
	
	@RequestMapping("/addressess")
	public List<Address> getAddress() {
		return addressSrv.getAddress();
	}
	
	@PostMapping("/address")
	public Address createNewAddress(@RequestBody Address payload) {
		
		return addressSrv.createAddress(payload); 
	}
}  
