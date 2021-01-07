package org.peakcoin.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.peakcoin.dao.UserDao;
import org.peakcoin.dao.impl.UserDaoImpl;
import org.peakcoin.domain.User;
import org.peakcoin.service.UserService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Stateless
@Local(UserService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UserServiceImpl extends GenericServiceImpl<User, Integer, UserDao> implements UserService {

	@Override
	protected UserDao getDao() {
		return new UserDaoImpl(em, se);
	}

}
