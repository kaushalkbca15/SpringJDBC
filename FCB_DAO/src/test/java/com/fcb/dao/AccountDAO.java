/*
 * Copyright (c) 2017, 2018, FCBDM and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.dao;

import com.fcb.beans.AccountStatus;

/**
 * This DAO is used to perform persistence operations on Account Table
 * 
 * @author sathish
 * @since FCBDM 1.0
 */
public interface AccountDAO {
	/**
	 * the method is used to get accountStatus 
	 * @param accountNumber
	 * @return accountStatus
	 */
public AccountStatus getAccountStatus(Integer accountNumber);
}
