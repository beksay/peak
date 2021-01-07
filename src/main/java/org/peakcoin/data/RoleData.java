package org.peakcoin.data;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;

import org.peakcoin.domain.Role;
import org.peakcoin.service.RoleService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@RequestScoped
public class RoleData extends BaseData<RoleService, Role, Integer> {

    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Role role) {
        retrieveAllMembersOrderedByName();
    }
    
    @Override
    protected void initFilter() {
    	list = new ArrayList<>();
    }

}
