/*
 * Copyright (c) 2017, 2018, FCBDM and/or its affiliates. All rights reserved.
 * FCBDM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fcb.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This DAO is used to perform persistence operations on EducationDetails Table
 * 
 * @author sathish
 * @since FCBDM 1.0
 */
@Repository
public class EducationDetailsDAOImpl implements EducationDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;

}
