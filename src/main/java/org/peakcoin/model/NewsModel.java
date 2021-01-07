package org.peakcoin.model;

import java.util.List;

import org.peakcoin.beans.FilterExample;
import org.peakcoin.domain.News;
import org.peakcoin.service.NewsService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class NewsModel extends BaseModel<NewsService, News, Integer> {

	private static final long serialVersionUID = -4871106869905562775L;

	public NewsModel(List<FilterExample> filters, NewsService service) {
		super(filters, service);
	}
	
	@Override
	protected Integer getKey(String key) {
		return Integer.parseInt(key);
	}
	
}
