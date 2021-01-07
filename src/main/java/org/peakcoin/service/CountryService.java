package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.Country;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface CountryService extends GenericService<Country, Integer> {

}
