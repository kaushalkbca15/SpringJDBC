/*
 * Copyright (c) 2017, 2018, FCBDM and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fcb.beans.AccountStatus;

/**
 * This DAO is used to perform persistence operations on Account Table
 * 
 * @author sathish
 * @since FCBDM 1.0
 */
@Repository("dao")
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * the method is used to get accountStatus 
	 * @param accountNumber
	 * @return accountStatus
	 */
	@Override
	public AccountStatus getAccountStatus(Integer accountNumber) {
		System.out.println("sessionFactory:   "+sessionFactory);
		return null;
	}

}
