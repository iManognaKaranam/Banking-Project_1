package com.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,String> {

	
}
