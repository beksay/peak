package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.Payment;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface PaymentService extends GenericService<Payment, Integer> {

}
