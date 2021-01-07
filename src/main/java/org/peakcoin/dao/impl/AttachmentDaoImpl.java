package org.peakcoin.dao.impl;

import javax.enterprise.event.Event;
import javax.persistence.EntityManager;

import org.peakcoin.dao.AttachmentDao;
import org.peakcoin.domain.Attachment;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class AttachmentDaoImpl extends GenericDaoImpl<Attachment, Integer> implements AttachmentDao {

	public AttachmentDaoImpl(EntityManager entityManager, Event<Attachment> eventSource) {
		super(entityManager, eventSource);
	}

}
