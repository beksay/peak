package org.peakcoin.conversations;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import org.peakcoin.annotation.Logged;
import org.peakcoin.domain.Country;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */
@Logged
@Named
@ConversationScoped
public class ConversationCountry extends Conversational {
	
	private static final long serialVersionUID = -6100072166946495229L;
	
	private Country country;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	
}
