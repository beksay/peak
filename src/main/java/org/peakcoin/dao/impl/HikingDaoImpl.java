package org.peakcoin.dao.impl;

import javax.enterprise.event.Event;
import javax.persistence.EntityManager;

import org.peakcoin.dao.HikingDao;
import org.peakcoin.domain.Hiking;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class HikingDaoImpl extends GenericDaoImpl<Hiking, Integer> implements HikingDao {

	public HikingDaoImpl(EntityManager entityManager, Event<Hiking> eventSource) {
		super(entityManager, eventSource);
	}

}
