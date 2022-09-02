package com.lti.bank.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lti.bank.model.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Long>{
	
	@Query("select t from Transactions t where dateOfTransaction between :startDate and :endDate")
	public List<Transactions> getTransactionByDate(@Param("startDate")Date startDate,@Param("endDate") Date endDate); 
	

}
