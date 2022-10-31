package com.andrecordeirolima.apiwebspring.repository;

import com.andrecordeirolima.apiwebspring.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {


}
