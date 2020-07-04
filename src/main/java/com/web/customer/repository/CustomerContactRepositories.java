package com.web.customer.repository;

import com.web.customer.model.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerContactRepositories extends JpaRepository<CustomerContact,Integer> {
}
