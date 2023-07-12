package com.in2itebs.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in2itebs.demo.entities.Vendor;

@Component
public class VendorService {
// this is like a internal table which contains multiple records
	HashMap<String, Vendor> vendors = new HashMap<String, Vendor>();
	
	@Autowired
	IVendorPersisitence vendor;
	
	
//	@Autowired
//	Vendor ven1;
//	
//	@Autowired
//	Vendor ven2;
//	
//	@Autowired
//	Vendor ven3;
	
	private void fillVendors()
	{
		//append work area to itab 
//		
//		vendors.put("1",ven1);
//		vendors.put("2",ven2);
//		vendors.put("3",ven3);
	}
	
	public void VendorService()
	{
		fillVendors();
	}
	
	public List<Vendor> getAllVendors()
	{  
		//Spring JPA will fire the SELECT query
		return vendor.findAll(); // findAll() will do the Select query
		//fillVendors();
		//return vendors;
	
	}
	public Optional<Vendor> getVendorByKey(String vendorId)
	{    
		
		//Send SELECT SINGLE * to database
		return vendor.findById(vendorId);   // Here vendor is the Interface name (i.e vendor)
		
		
		// read table itab into into work area key ve=id
//		fillVendors();
//		return (Vendor)vendors.get(vendorId);
	}
	
	public Vendor createVendor(Vendor vendorObject) {
		
		//Spring JPA will fire INSERT INTO db table
		return vendor.save(vendorObject); 
				
//		fillVendors();
//		vendors.put("4", vendor);
//		return vendor;
	}
	
	public Vendor updateVendor(Vendor vendorObject)
	{
		//Spring will fire the UPDATE call
		
	Optional<Vendor> searchedRecord = vendor.findById(vendorObject.getCode());
		if(!searchedRecord.isPresent())
		{
			return new Vendor();// it will return blank record  
		}
		return vendor.save(vendorObject);
		
//		fillVendors();
//		return vendor;
	}
	
	public List<Vendor> searchByCompanyName(String company){
		return vendor.findByCompanyName(company);
	}
	
	
	public List<Vendor> lookupByFirstName(String firstName){
		return vendor.lookupByFirstName(firstName);
	}
	
	
	public String deleteVendor(String vendorId)
	{	
		vendor.deleteById(vendorId);
		return "Deleted Succesfully";
		
//		fillVendors();
//		vendors.remove(vendorId);
	}
	
 	
	
}
