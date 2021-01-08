package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.Company;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface CompanyService extends GenericService<Company, Integer> {

}
