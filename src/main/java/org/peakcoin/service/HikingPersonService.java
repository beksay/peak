package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.HikingPerson;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface HikingPersonService extends GenericService<HikingPerson, Integer> {

}
