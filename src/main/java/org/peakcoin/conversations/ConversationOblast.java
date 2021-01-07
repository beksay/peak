package org.peakcoin.conversations;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import org.peakcoin.annotation.Logged;
import org.peakcoin.domain.Oblast;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */
@Logged
@Named
@ConversationScoped
public class ConversationOblast extends Conversational {
	
	private static final long serialVersionUID = -6100072166946495229L;
	
	private Oblast oblast;

	public Oblast getOblast() {
		return oblast;
	}

	public void setOblast(Oblast oblast) {
		this.oblast = oblast;
	}

	
}
