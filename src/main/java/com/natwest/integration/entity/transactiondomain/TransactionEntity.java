package com.natwest.integration.entity.transactiondomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Use this class to store and use DB of the Transaction domain.
 * 
 * @author Pijush Kanti Das
 *
 */
@Data
@Entity
@Table(name = "ACCOUNT")
public class TransactionEntity {

	@Id
	@Column(name = "TRANSACTION_ID")
	private Integer transactionId;
	
	@Column(name = "SOURCE_ACCOUNT_NUMBER")
	private Integer sourceAccountNumber;
	
	@Column(name = "DESTINATION_ACCOUNT_NUMBER")
	private Integer destinationAccountNumber;
	
	@Column(name = "AMOUNT")
	private Float amount;
}
