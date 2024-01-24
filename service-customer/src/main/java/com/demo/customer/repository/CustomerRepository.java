package com.demo.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.customer.entity.Customer;
import com.demo.customer.entity.Region;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByNumberID(String numberID);

	public List<Customer> findByLastName(String lastName);

	public List<Customer> findByRegion(Region region);

}
