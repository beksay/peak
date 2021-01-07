package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.Person;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface PersonService extends GenericService<Person, Integer> {

}
