package com.natwest.service.accountdomain.unittest;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.natwest.common.NatwestApiGenericException;
import com.natwest.integration.dao.accountdomain.AccountDao;
import com.natwest.integration.dao.transactiondomain.TransactionDao;
import com.natwest.integration.entity.accountdomain.AccountEntity;
import com.natwest.service.accountdomain.AccountService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceTest {
	
	@Mock
	private AccountDao anAccountDao;
	
	@Mock
	private TransactionDao aTransactionDao;
	
	
	@InjectMocks
	AccountService anAccountService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		AccountEntity sourceAccount = new AccountEntity();
		AccountEntity destinationAccount = new AccountEntity();
		sourceAccount.setAccountNumber(100);
		sourceAccount.setBalance(1000F);
		destinationAccount.setAccountNumber(200);
		destinationAccount.setBalance(2000F);
		when(anAccountDao.findById(100)).thenReturn(Optional.of(sourceAccount));
		when(anAccountDao.findById(200)).thenReturn(Optional.of(destinationAccount));
	}

	@Test(expected = NatwestApiGenericException.class)
	public void testExecuteTransactionSourceAccountNull() {
		anAccountService.executeTransaction(null, null, null);
	}
	
	@Test(expected = NatwestApiGenericException.class)
	public void testExecuteTransactionDestinationAccountNull() {
		anAccountService.executeTransaction(123, null, null);
	}
	
	@Test
	@Ignore /** Integration test will test the real transaction */
	public void testExecuteTransaction() {
		anAccountService.executeTransaction(100, 200, 30F);
		assertTrue(true);
		
	}

}
