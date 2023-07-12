package com.in2itebs.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in2itebs.demo.entities.Address;

public interface IAddressPersistence extends JpaRepository<Address, String>{



}
