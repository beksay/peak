package org.peakcoin.service;

import javax.ejb.Local;

import org.peakcoin.domain.Role;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Local
public interface RoleService extends GenericService<Role, Integer> {

}
