package org.peakcoin.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.peakcoin.dao.HikingDao;
import org.peakcoin.dao.impl.HikingDaoImpl;
import org.peakcoin.domain.Hiking;
import org.peakcoin.service.HikingService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Stateless
@Local(HikingService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class HikingServiceImpl extends GenericServiceImpl<Hiking, Integer, HikingDao> implements HikingService {

	@Override
	protected HikingDao getDao() {
		return new HikingDaoImpl(em, se);
	}

}
