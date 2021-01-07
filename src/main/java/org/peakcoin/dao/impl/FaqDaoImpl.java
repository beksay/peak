package org.peakcoin.dao.impl;

import javax.enterprise.event.Event;
import javax.persistence.EntityManager;

import org.peakcoin.dao.FaqDao;
import org.peakcoin.domain.Faq;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class FaqDaoImpl extends GenericDaoImpl<Faq, Integer> implements FaqDao {

	public FaqDaoImpl(EntityManager entityManager, Event<Faq> eventSource) {
		super(entityManager, eventSource);
	}

}
