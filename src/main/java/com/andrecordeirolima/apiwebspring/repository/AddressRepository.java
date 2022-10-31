package com.andrecordeirolima.apiwebspring.repository;

import com.andrecordeirolima.apiwebspring.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}
