package com.in2itebs.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.in2itebs.demo.entities.Vendor;

public interface IVendorPersisitence extends JpaRepository<Vendor, String> {

	List <Vendor> findByCompanyName(String companyNmae);

	
	@Query(nativeQuery=true, value="SELECT * FROM public.vendor where lower(first_name) like %?1% ")
	List <Vendor> lookupByFirstName(String firstname);
}
  