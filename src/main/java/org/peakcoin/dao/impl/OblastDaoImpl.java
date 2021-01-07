package org.peakcoin.dao.impl;

import javax.enterprise.event.Event;
import javax.persistence.EntityManager;

import org.peakcoin.dao.OblastDao;
import org.peakcoin.domain.Oblast;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class OblastDaoImpl extends GenericDaoImpl<Oblast, Integer> implements OblastDao {

	public OblastDaoImpl(EntityManager entityManager, Event<Oblast> eventSource) {
		super(entityManager, eventSource);
	}

}
