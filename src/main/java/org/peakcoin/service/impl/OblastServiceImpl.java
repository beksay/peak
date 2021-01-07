package org.peakcoin.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.peakcoin.dao.OblastDao;
import org.peakcoin.dao.impl.OblastDaoImpl;
import org.peakcoin.domain.Oblast;
import org.peakcoin.service.OblastService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Stateless
@Local(OblastService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class OblastServiceImpl extends GenericServiceImpl<Oblast, Integer, OblastDao> implements OblastService {

	@Override
	protected OblastDao getDao() {
		return new OblastDaoImpl(em, se);
	}

}
