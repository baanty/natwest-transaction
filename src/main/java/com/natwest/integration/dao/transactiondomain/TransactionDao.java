package com.natwest.integration.dao.transactiondomain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natwest.integration.entity.transactiondomain.TransactionEntity;

/**
 * Use this interface to use the account details.
 * 
 * @author Pijush Kanti Das
 *
 */
@Repository
public interface TransactionDao extends JpaRepository<TransactionEntity, Integer>{

}
