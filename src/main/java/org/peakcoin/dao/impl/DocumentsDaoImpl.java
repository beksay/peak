package org.peakcoin.dao.impl;

import javax.enterprise.event.Event;
import javax.persistence.EntityManager;

import org.peakcoin.dao.DocumentsDao;
import org.peakcoin.domain.Documents;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class DocumentsDaoImpl extends GenericDaoImpl<Documents, Integer> implements DocumentsDao {

	public DocumentsDaoImpl(EntityManager entityManager, Event<Documents> eventSource) {
		super(entityManager, eventSource);
	}

}
