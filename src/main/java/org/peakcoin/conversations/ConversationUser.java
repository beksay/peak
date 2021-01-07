package org.peakcoin.conversations;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import org.peakcoin.annotation.Logged;
import org.peakcoin.domain.Person;
import org.peakcoin.domain.User;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */
@Logged
@Named
@ConversationScoped
public class ConversationUser extends Conversational {
	
	private static final long serialVersionUID = -6100072166946495229L;
	
	private User user;
	private Person person;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

	
}
