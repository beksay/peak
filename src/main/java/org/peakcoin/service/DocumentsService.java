package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.Documents;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface DocumentsService extends GenericService<Documents, Integer> {

}
