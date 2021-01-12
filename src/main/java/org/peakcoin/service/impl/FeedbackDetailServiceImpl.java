package org.peakcoin.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.peakcoin.dao.FeedbackDetailDao;
import org.peakcoin.dao.impl.FeedbackDetailDaoImpl;
import org.peakcoin.domain.FeedbackDetail;
import org.peakcoin.service.FeedbackDetailService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Stateless
@Local(FeedbackDetailService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class FeedbackDetailServiceImpl extends GenericServiceImpl<FeedbackDetail, Integer, FeedbackDetailDao> implements FeedbackDetailService {

	@Override
	protected FeedbackDetailDao getDao() {
		return new FeedbackDetailDaoImpl(em, se);
	}

}
