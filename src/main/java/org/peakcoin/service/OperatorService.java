package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.Operator;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface OperatorService extends GenericService<Operator, Integer> {

}
