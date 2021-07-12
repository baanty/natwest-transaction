package com.natwest.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class TransactionVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3618637125371175646L;
	
	private Integer sourceAccount;
	
	private Integer destinationAccount;
	
	private Float amount;

}
