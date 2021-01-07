package org.peakcoin.controller.publics;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.peakcoin.conversations.Conversational;
import org.peakcoin.domain.Complaints;
import org.peakcoin.service.ComplaintsService;
import org.peakcoin.util.web.FacesMessages;
import org.peakcoin.util.web.Messages;
import org.peakcoin.validator.EntityValidator;


@Named
@ConversationScoped
public class ComplaintsController extends Conversational{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ComplaintsService service;
	@Inject
	private EntityValidator validator;
	private Complaints complaints;
	
	@PostConstruct
	public void initialize() {
		complaints = new Complaints();
	}
    
	public String save() {
		if(complaints == null){
			FacesMessages.addMessage(Messages.getMessage("invalidData"), Messages.getMessage("invalidData"), null);
			return null;
		}
 		complaints.setDateCreated(new Date());
		validator.validate(complaints);
		if(!FacesContext.getCurrentInstance().getMessageList().isEmpty()) return null;
		
		if (complaints.getId() == null) {
			service.persist(complaints);
		} else {
			service.merge(complaints);
		}
		complaints = new Complaints();	
		return "/view/public/footer/thank_you.xhtml?faces-redirect=true";
	}
	
	public String cancel() {
		complaints = null;
		return "/home.xhtml?faces-redirect=true";
    }
	
	public String complaintsList() {
		complaints = new Complaints();
		return "/view/public/footer/complaints.xhtml?faces-redirect=true";
	}

	public Complaints getComplaints() {
		return complaints;
	}

	public void setComplaints(Complaints complaints) {
		this.complaints = complaints;
	}


}
