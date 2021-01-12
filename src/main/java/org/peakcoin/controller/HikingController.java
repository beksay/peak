package org.peakcoin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.peakcoin.annotation.Logged;
import org.peakcoin.beans.FilterExample;
import org.peakcoin.beans.InequalityConstants;
import org.peakcoin.conversations.ConversationHiking;
import org.peakcoin.domain.Company;
import org.peakcoin.domain.Feedback;
import org.peakcoin.domain.FeedbackDetail;
import org.peakcoin.domain.Hiking;
import org.peakcoin.domain.HikingPerson;
import org.peakcoin.enums.SortEnum;
import org.peakcoin.service.CompanyService;
import org.peakcoin.service.FeedbackDetailService;
import org.peakcoin.service.FeedbackService;
import org.peakcoin.service.HikingPersonService;
import org.peakcoin.service.HikingService;
import org.peakcoin.service.PersonService;
import org.peakcoin.service.UserService;
import org.peakcoin.util.web.FacesMessages;
import org.peakcoin.util.web.LoginUtil;
import org.peakcoin.util.web.Messages;

@Logged
@ManagedBean
@ViewScoped
public class HikingController {

	@EJB
	private HikingService service;
	@EJB
	private HikingPersonService hikingPersonService;
	@EJB
	private PersonService personService;
	@EJB
	private CompanyService companyService;
	@EJB
	private UserService userService;
	@EJB
	private FeedbackService feedbackService;
	@EJB
	private FeedbackDetailService feedbackDetailService;
	@Inject
	private LoginUtil loginUtil;
	@Inject
	private ConversationHiking conversation;	

	private Hiking hiking; 
	private Company company;
	private HikingPerson hikingPerson;
	private Feedback feedback;
    
	@PostConstruct
	public void init() {
		hiking=conversation.getHiking();
		if (hiking==null)	hiking= new Hiking();
		company=conversation.getCompany();
		hikingPerson=conversation.getHikingPerson();
		if (hikingPerson==null)	hikingPerson= new HikingPerson();
		feedback=conversation.getFeedback();
		if (feedback==null)	feedback= new Feedback();
	}

	public String add() {
		hiking=conversation.getHiking();
		if (hiking==null)	hiking= new Hiking();
        return form();
    }
	
	public String preview(Hiking hiking) {
		this.hiking = hiking;
		conversation.setHiking(hiking);
		return infoForm();
	}
	
	public String linkCompany(Hiking hiking) {
		this.setCompany(hiking.getCompany());
		this.hiking = hiking;
		conversation.setHiking(hiking);
		conversation.setCompany(company);
		return companyForm();
	}
	
	public String joinHiking(Hiking hiking) {
    	List<FilterExample> checkFilter = new ArrayList<>();
    	checkFilter.add(new FilterExample("hiking", hiking, InequalityConstants.EQUAL));
    	Long quantity = hikingPersonService.countByExample(checkFilter);
    	if (quantity>=hiking.getQuantity()) {
    		FacesContext.getCurrentInstance().addMessage("form", new FacesMessage( FacesMessage.SEVERITY_ERROR,  Messages.getMessage("noPlaceToJoin"), null) );
			return null;
		}	
    	hikingPerson.setDate(new Date());
    	hikingPerson.setHiking(hiking);
    	hikingPerson.setPerson(loginUtil.getCurrentUser().getPerson());
    	hikingPersonService.persist(hikingPerson);
    	hikingPerson = new HikingPerson();
		return null;
	}
	
	public String delete(HikingPerson hikingPerson) {
    	hikingPersonService.remove(hikingPerson);
    	hikingPerson = new HikingPerson();
		return null;
	}
	
	public String save() {
		System.out.println(hiking);
		if(hiking == null){
			FacesMessages.addMessage(Messages.getMessage("invalidData"), Messages.getMessage("invalidData"), null);
			return null;
		}
		if (hiking.getId() == null) {
			hiking.setCompany(loginUtil.getCurrentUser().getCompany());
			hiking.setDateCreated(new Date());
			service.persist(hiking);
		} else {
			service.merge(hiking);
		}
		conversation.setHiking(null);
	    return cancel();  
	}
	
	public String cancel() {
		hiking = null;
		return list();
	}
	
	private String list() {
		return "/view/hiking/hiking_list.xhtml?faces-redirect=true";
	}
	
	private String form() {
		return "/view/hiking/hiking_form.xhtml";
	}
	
	private String infoForm() {
		return "/view/hiking/hiking_info.xhtml";
	}
	
	private String companyForm() {
		return "/view/hiking/company_info.xhtml";
	}
	
	public List<HikingPerson> getHikingPersonList(Hiking hiking) {
		List<FilterExample> examples = new ArrayList<>();
		examples.add(new FilterExample("hiking", hiking, InequalityConstants.EQUAL));
		return hikingPersonService.findByExample(0, 1000, SortEnum.DESCENDING, examples, "date");
	}
	
	public Long getHikingPersonNumber(Hiking hiking) {
		List<FilterExample> examples = new ArrayList<>();
		examples.add(new FilterExample("hiking", hiking, InequalityConstants.EQUAL));
		return hikingPersonService.countByExample(examples);
	}
	
	public Boolean isJoined(Hiking hiking) {
		List<FilterExample> filters = new ArrayList<>();
		filters.add(new FilterExample("person", loginUtil.getCurrentUser().getPerson(), InequalityConstants.EQUAL));
		filters.add(new FilterExample("hiking", hiking, InequalityConstants.EQUAL));
		Long checkParticipant = hikingPersonService.countByExample(filters);
    	if(checkParticipant>0){
    		return true;
    	}else {
			return false;
		}
	}
	
	public void sendFeedback() {
		if(feedback==null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Select the feedback!","Select the feedback!"));
			return;
		}
		feedback.setHiking(hiking);;
		feedback.setUser(loginUtil.getCurrentUser());
		feedback.setDate(new Date());
		feedbackService.persist(feedback);
		feedback = new Feedback();
	}
	
	public List<Feedback> getFeedbackList(Hiking hiking) {
		List<FilterExample> examples = new ArrayList<>();
		examples.add(new FilterExample("hiking", hiking, InequalityConstants.EQUAL));	
		return feedbackService.findByExample(0, 100, SortEnum.DESCENDING, examples, "date");
	}
	
	public List<FeedbackDetail> getFeedbackDetailList(Feedback feedback) {
		List<FilterExample> examples = new ArrayList<>();
		examples.add(new FilterExample("feedback", feedback, InequalityConstants.EQUAL));		
		return feedbackDetailService.findByExample(0, 100, SortEnum.DESCENDING, examples, "date");
	}
	
	public Boolean checkDetail(Feedback feedback) {
    	List<FilterExample> examples = new ArrayList<>();
		examples.add(new FilterExample("feedback", feedback, InequalityConstants.EQUAL));	
		List<FeedbackDetail> details = feedbackDetailService.findByExample(0, 10, examples);
     	if (details.size()>0) {
			return true;
		} else {
            return false;
		}
    }
	
	public ConversationHiking getConversation() {
		return conversation;
	}
	
	public void setConversation(ConversationHiking conversation) {
		this.conversation = conversation;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

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

	public Long getParticipantAmount(Hiking hiking) {
		List<FilterExample> examples = new ArrayList<>();
		examples.add(new FilterExample("hiking", hiking, InequalityConstants.EQUAL));
		return hikingPersonService.countByExample(examples);
	}
	
	public Feedback getFeedback() {
		return feedback;
	}
	
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
}
