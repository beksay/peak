package org.peakcoin.dao.impl;

import javax.enterprise.event.Event;
import javax.persistence.EntityManager;

import org.peakcoin.dao.UserDao;
import org.peakcoin.domain.User;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

	public UserDaoImpl(EntityManager entityManager, Event<User> eventSource) {
		super(entityManager, eventSource);
	}

}
