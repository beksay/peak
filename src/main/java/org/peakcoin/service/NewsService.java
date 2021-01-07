package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.News;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface NewsService extends GenericService<News, Integer> {

}
