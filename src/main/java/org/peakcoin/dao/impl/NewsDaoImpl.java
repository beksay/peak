package org.peakcoin.dao.impl;

import javax.enterprise.event.Event;
import javax.persistence.EntityManager;

import org.peakcoin.dao.NewsDao;
import org.peakcoin.domain.News;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class NewsDaoImpl extends GenericDaoImpl<News, Integer> implements NewsDao {

	public NewsDaoImpl(EntityManager entityManager, Event<News> eventSource) {
		super(entityManager, eventSource);
	}

}
