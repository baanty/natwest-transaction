package com.natwest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.natwest.common.TransactionVo;
import com.natwest.integration.dao.accountdomain.AccountDao;
import com.natwest.integration.entity.accountdomain.AccountEntity;
import com.natwest.presentation.controller.transactiondomain.TransactionController;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionControllerTest {
	
	@Autowired
	TransactionController controller;
	
	@Autowired
	AccountDao anAccountDao;

	@Test
	@DirtiesContext
	public void testDoTransaction() {
		TransactionVo aTransactionVo = new TransactionVo();
		aTransactionVo.setAmount(10F);
		aTransactionVo.setSourceAccount(1);
		aTransactionVo.setDestinationAccount(2);
		
		controller.doTransaction(aTransactionVo);
		
		Optional<AccountEntity> optionalSourceAccountEntity = anAccountDao.findById(1);
		Optional<AccountEntity> optionalDestinationAccountEntity = anAccountDao.findById(2);
		
		assertTrue(optionalSourceAccountEntity.isPresent());
		
		AccountEntity source = optionalSourceAccountEntity.get();
		AccountEntity destination = optionalDestinationAccountEntity.get();
		
		assertEquals(90F, source.getBalance());
		assertEquals(210F, destination.getBalance());
		
	}

}
