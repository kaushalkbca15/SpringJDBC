/*
 * Copyright (c) 2017, 2018, FCBDM and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */


package com.fcb.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * This DAO is used to perform persistence operations on Account Table
 * 
 * @author sathish
 * @since FCBDM 1.0
 */
@Repository
public class PresentAdressDAOimpl implements PresentAdressDAO{
	private SessionFactory sessionfactory;

}
