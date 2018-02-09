package com.fcb.beans;

import java.io.Serializable;

public class AccountStatus implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private Integer accountNumber;
	private Integer accountStatus;
	private String accountHolderName;
	private String branchName;

	/**
	 * @return the accountNumber
	 */
	public Integer getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountStatus
	 */
	public Integer getAccountStatus() {
		return accountStatus;
	}

	/**
	 * @param accountStatus
	 *            the accountStatus to set
	 */
	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

	/**
	 * @return the accountHolderName
	 */
	public String getAccountHolderName() {
		return accountHolderName;
	}

	/**
	 * @param accountHolderName
	 *            the accountHolderName to set
	 */
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName
	 *            the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}
