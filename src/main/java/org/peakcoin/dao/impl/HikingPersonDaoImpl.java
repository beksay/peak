package org.peakcoin.dao.impl;

import javax.enterprise.event.Event;
import javax.persistence.EntityManager;

import org.peakcoin.dao.HikingPersonDao;
import org.peakcoin.domain.HikingPerson;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class HikingPersonDaoImpl extends GenericDaoImpl<HikingPerson, Integer> implements HikingPersonDao {

	public HikingPersonDaoImpl(EntityManager entityManager, Event<HikingPerson> eventSource) {
		super(entityManager, eventSource);
	}

}
