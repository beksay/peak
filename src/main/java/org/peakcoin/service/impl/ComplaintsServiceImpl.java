package org.peakcoin.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.peakcoin.dao.ComplaintsDao;
import org.peakcoin.dao.impl.ComplaintsDaoImpl;
import org.peakcoin.domain.Complaints;
import org.peakcoin.service.ComplaintsService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Stateless
@Local(ComplaintsService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ComplaintsServiceImpl extends GenericServiceImpl<Complaints, Integer, ComplaintsDao> implements ComplaintsService {

	@Override
	protected ComplaintsDao getDao() {
		return new ComplaintsDaoImpl(em, se);
	}

}
