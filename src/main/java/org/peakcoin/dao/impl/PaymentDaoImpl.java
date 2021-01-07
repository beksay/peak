package org.peakcoin.dao.impl;

import javax.enterprise.event.Event;
import javax.persistence.EntityManager;

import org.peakcoin.dao.PaymentDao;
import org.peakcoin.domain.Payment;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class PaymentDaoImpl extends GenericDaoImpl<Payment, Integer> implements PaymentDao {

	public PaymentDaoImpl(EntityManager entityManager, Event<Payment> eventSource) {
		super(entityManager, eventSource);
	}

}
