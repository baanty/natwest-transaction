package com.natwest.service.accountdomain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.natwest.common.Constants;
import com.natwest.common.NatwestApiGenericException;
import com.natwest.integration.dao.accountdomain.AccountDao;
import com.natwest.integration.dao.transactiondomain.TransactionDao;
import com.natwest.integration.entity.accountdomain.AccountEntity;
import com.natwest.integration.entity.transactiondomain.TransactionEntity;

@Service
public class AccountService implements Constants {
	
	@Autowired
	private AccountDao anAccountDao;
	
	@Autowired
	private TransactionDao aTransactionDao;

	@Transactional( isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW )
	public String executeTransaction(final Integer sourceAccountNumber, 
								     final Integer destinationAccountNumber,
								     final Float amount) {
		
		Optional<AccountEntity> optionalSourceAccount = anAccountDao.findById(sourceAccountNumber);
		Optional<AccountEntity> optionalDestinationAccount = anAccountDao.findById(destinationAccountNumber);
		
		if ( optionalSourceAccount.isEmpty() ) {
			throw new NatwestApiGenericException("Source Account - " + sourceAccountNumber + " not found .");
		}
		
		if ( optionalDestinationAccount.isEmpty() ) {
			throw new NatwestApiGenericException("Destination Account - " + destinationAccountNumber + " not found .");
		}
		
		AccountEntity sourceAccount = optionalSourceAccount.get();
		AccountEntity destinationAccount = optionalDestinationAccount.get();
		sourceAccount.setBalance(sourceAccount.getBalance() - amount);
		destinationAccount.setBalance(destinationAccount.getBalance() + amount);
		
		TransactionEntity aNewTransactionEntity = new TransactionEntity();
		aNewTransactionEntity.setAmount(amount);
		aNewTransactionEntity.setSourceAccountNumber(sourceAccount.getAccountNumber());
		aNewTransactionEntity.setDestinationAccountNumber(destinationAccount.getAccountNumber());
		
		anAccountDao.saveAndFlush(sourceAccount);
		anAccountDao.saveAndFlush(destinationAccount);
		aTransactionDao.saveAndFlush(aNewTransactionEntity);

		
		return SUCCESS;
	}
}
