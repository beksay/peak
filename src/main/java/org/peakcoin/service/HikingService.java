package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.Hiking;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface HikingService extends GenericService<Hiking, Integer> {

}
