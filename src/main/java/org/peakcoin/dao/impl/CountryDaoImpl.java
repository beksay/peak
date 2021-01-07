package org.peakcoin.dao.impl;

import javax.enterprise.event.Event;
import javax.persistence.EntityManager;

import org.peakcoin.dao.CountryDao;
import org.peakcoin.domain.Country;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class CountryDaoImpl extends GenericDaoImpl<Country, Integer> implements CountryDao {

	public CountryDaoImpl(EntityManager entityManager, Event<Country> eventSource) {
		super(entityManager, eventSource);
	}

}
