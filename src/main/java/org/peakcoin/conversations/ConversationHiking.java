package org.peakcoin.conversations;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import org.peakcoin.annotation.Logged;
import org.peakcoin.domain.Company;
import org.peakcoin.domain.Feedback;
import org.peakcoin.domain.FeedbackDetail;
import org.peakcoin.domain.Hiking;
import org.peakcoin.domain.HikingPerson;
import org.peakcoin.domain.Person;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */
@Logged
@Named
@ConversationScoped
public class ConversationHiking extends Conversational {
	
	private static final long serialVersionUID = -6100072166946495229L;
	
	private Hiking hiking;
	private HikingPerson hikingPerson;
	private Company company;
	private Person person;
	private Feedback feedback;
	private FeedbackDetail feedbackDetail;
	private Boolean replyButton;

	public Hiking getHiking() {
		return hiking;
	}

	public void setHiking(Hiking hiking) {
		this.hiking = hiking;
	}

	public HikingPerson getHikingPerson() {
		return hikingPerson;
	}

	public void setHikingPerson(HikingPerson hikingPerson) {
		this.hikingPerson = hikingPerson;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public FeedbackDetail getFeedbackDetail() {
		return feedbackDetail;
	}

	public void setFeedbackDetail(FeedbackDetail feedbackDetail) {
		this.feedbackDetail = feedbackDetail;
	}

	public Boolean getReplyButton() {
		return replyButton;
	}

	public void setReplyButton(Boolean replyButton) {
		this.replyButton = replyButton;
	}

	public String change(Feedback feedback) {
		this.feedback = feedback;
		replyButton = true;
		return null;
	}
	
}
