package org.peakcoin.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.peakcoin.dao.FaqDao;
import org.peakcoin.dao.impl.FaqDaoImpl;
import org.peakcoin.domain.Faq;
import org.peakcoin.service.FaqService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Stateless
@Local(FaqService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class FaqServiceImpl extends GenericServiceImpl<Faq, Integer, FaqDao> implements FaqService {

	@Override
	protected FaqDao getDao() {
		return new FaqDaoImpl(em, se);
	}

}
