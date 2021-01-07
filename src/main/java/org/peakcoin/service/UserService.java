package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.User;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface UserService extends GenericService<User, Integer> {

}
