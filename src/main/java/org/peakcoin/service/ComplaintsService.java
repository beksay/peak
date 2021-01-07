package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.Complaints;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface ComplaintsService extends GenericService<Complaints, Integer> {

}
