package org.peakcoin.dao.impl;

import javax.enterprise.event.Event;
import javax.persistence.EntityManager;

import org.peakcoin.dao.ComplaintsDao;
import org.peakcoin.domain.Complaints;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class ComplaintsDaoImpl extends GenericDaoImpl<Complaints, Integer> implements ComplaintsDao {

	public ComplaintsDaoImpl(EntityManager entityManager, Event<Complaints> eventSource) {
		super(entityManager, eventSource);
	}

}
