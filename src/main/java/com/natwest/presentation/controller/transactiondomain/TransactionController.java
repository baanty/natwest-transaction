package com.natwest.presentation.controller.transactiondomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.common.TransactionVo;
import com.natwest.service.accountdomain.AccountService;

/**
 * Use this class to make the rest controller front end.
 * 
 * @author Pijush Kanti Das
 *
 */
@RestController
public class TransactionController {

	@Autowired
	private AccountService anAccountService;
	
	/**
	 * This method transfers the amount from one account to the
	 * another.
	 * 
	 * @param aTransactionVo
	 * @return
	 */
	@PostMapping("/transfer")
	public String doTransaction(@RequestBody final TransactionVo aTransactionVo) {
		return anAccountService.executeTransaction(aTransactionVo.getSourceAccount(), aTransactionVo.getDestinationAccount(), aTransactionVo.getAmount());
	}
}
