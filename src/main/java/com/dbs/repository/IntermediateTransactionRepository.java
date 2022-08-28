package com.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.model.IntermediateTransaction;

public interface IntermediateTransactionRepository extends JpaRepository<IntermediateTransaction,Long>{

	
}
