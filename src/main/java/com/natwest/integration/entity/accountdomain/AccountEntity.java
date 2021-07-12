package com.natwest.integration.entity.accountdomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Use this class to represent the DB tables of account.
 * 
 * @author Pijush Kanti Das
 *
 */
@Data
@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {

	@Id
	@Column(name = "ACCOUNT_NUMBER")
	private Integer accountNumber;
	
	@Column(name = "BALANCE")
	private Float balance;
}
