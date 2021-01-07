package org.peakcoin.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.peakcoin.dao.PaymentDao;
import org.peakcoin.dao.impl.PaymentDaoImpl;
import org.peakcoin.domain.Payment;
import org.peakcoin.service.PaymentService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Stateless
@Local(PaymentService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PaymentServiceImpl extends GenericServiceImpl<Payment, Integer, PaymentDao> implements PaymentService {

	@Override
	protected PaymentDao getDao() {
		return new PaymentDaoImpl(em, se);
	}

}
