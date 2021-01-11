package org.peakcoin.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.peakcoin.dao.HikingPersonDao;
import org.peakcoin.dao.impl.HikingPersonDaoImpl;
import org.peakcoin.domain.HikingPerson;
import org.peakcoin.service.HikingPersonService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Stateless
@Local(HikingPersonService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class HikingPersonServiceImpl extends GenericServiceImpl<HikingPerson, Integer, HikingPersonDao> implements HikingPersonService {

	@Override
	protected HikingPersonDao getDao() {
		return new HikingPersonDaoImpl(em, se);
	}

}
