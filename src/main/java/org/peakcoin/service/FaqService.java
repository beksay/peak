package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.Faq;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface FaqService extends GenericService<Faq, Integer> {

}
