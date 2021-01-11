package org.peakcoin.model;

import java.util.List;

import org.peakcoin.beans.FilterExample;
import org.peakcoin.domain.Hiking;
import org.peakcoin.service.HikingService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class HikingModel extends BaseModel<HikingService, Hiking, Integer> {

	private static final long serialVersionUID = -4871106869905562775L;

	public HikingModel(List<FilterExample> filters, HikingService service) {
		super(filters, service);
	}
	
	@Override
	protected Integer getKey(String key) {
		return Integer.parseInt(key);
	}
	
}
