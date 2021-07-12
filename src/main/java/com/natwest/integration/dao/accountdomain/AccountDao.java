package com.natwest.integration.dao.accountdomain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natwest.integration.entity.accountdomain.AccountEntity;

/**
 * Use this interface to use the account details.
 * 
 * @author Pijush Kanti Das
 *
 */
@Repository
public interface AccountDao extends JpaRepository<AccountEntity, Integer>{

}
