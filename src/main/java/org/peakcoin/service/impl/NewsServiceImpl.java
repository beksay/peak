package org.peakcoin.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.peakcoin.dao.NewsDao;
import org.peakcoin.dao.impl.NewsDaoImpl;
import org.peakcoin.domain.News;
import org.peakcoin.service.NewsService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Stateless
@Local(NewsService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class NewsServiceImpl extends GenericServiceImpl<News, Integer, NewsDao> implements NewsService {

	@Override
	protected NewsDao getDao() {
		return new NewsDaoImpl(em, se);
	}

}
