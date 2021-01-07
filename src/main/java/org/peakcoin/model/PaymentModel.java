package org.peakcoin.model;

import java.util.List;

import org.peakcoin.beans.FilterExample;
import org.peakcoin.domain.Payment;
import org.peakcoin.service.PaymentService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class PaymentModel extends BaseModel<PaymentService, Payment, Integer> {

	private static final long serialVersionUID = -4871106869905562775L;

	public PaymentModel(List<FilterExample> filters, PaymentService service) {
		super(filters, service);
	}
	
	@Override
	protected Integer getKey(String key) {
		return Integer.parseInt(key);
	}
	
}
