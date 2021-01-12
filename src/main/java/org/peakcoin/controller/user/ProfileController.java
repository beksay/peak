package org.peakcoin.controller.user;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.peakcoin.annotation.Logged;
import org.peakcoin.conversations.Conversational;
import org.peakcoin.domain.Company;
import org.peakcoin.domain.Person;
import org.peakcoin.domain.User;
import org.peakcoin.service.CompanyService;
import org.peakcoin.service.PersonService;
import org.peakcoin.service.UserService;
import org.peakcoin.util.web.Messages;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Logged
@Named
@ConversationScoped
public class ProfileController extends Conversational {

	private static final long serialVersionUID = 5651758429305872940L;
	
	@EJB
	private UserService service;
	@EJB
	private PersonService personService;
	@EJB
	private CompanyService companyService;
	
	private User user;
	private Person person;
	private Company company;
	private Boolean editProfile;

	@PostConstruct
	public void init() {
		if (user==null)	user= new User();
		if (person==null) person= new Person();
		if (company==null) company= new Company();
		editProfile = false;
	}
	
	public String change() {
		editProfile = true;
		return null;
	}
	
	public String cancel() {
		editProfile=false;
		return null;
	}
	
	public String save() {
		List<User> users = service.findByProperty("email", user.getEmail());
    	if(users.equals(0)){
    		FacesContext.getCurrentInstance().addMessage("form", new FacesMessage( FacesMessage.SEVERITY_ERROR,  Messages.getMessage("emailIsAlreadyExists"), null) );
			return null;
    	}
		
		user.setPerson(person);
		if(!FacesContext.getCurrentInstance().getMessageList().isEmpty()) return null;
		personService.merge(user.getPerson());
		service.merge(user);
		
		FacesContext.getCurrentInstance().addMessage("form", new FacesMessage( FacesMessage.SEVERITY_INFO,  Messages.getMessage("dataDaved"), null) );
		editProfile = false;
		return null;
	}
	
	public String saveCompany() {
		List<User> users = service.findByProperty("email", user.getEmail());
    	if(users.equals(0)){
    		FacesContext.getCurrentInstance().addMessage("form", new FacesMessage( FacesMessage.SEVERITY_ERROR,  Messages.getMessage("emailIsAlreadyExists"), null) );
			return null;
    	}
		
		user.setCompany(company);
		if(!FacesContext.getCurrentInstance().getMessageList().isEmpty()) return null;
		companyService.merge(user.getCompany());
		service.merge(user);
		
		FacesContext.getCurrentInstance().addMessage("form", new FacesMessage( FacesMessage.SEVERITY_INFO,  Messages.getMessage("dataDaved"), null) );
		editProfile = false;
		return null;
	}
	
	public String goProfile(User user) {
		this.user = user;
		person = personService.findById(user.getPerson().getId(), false);
		return "/view/profile/my_profile.xhtml";
	}
	
	public String goCompany(User user) {
		this.user = user;
		company = companyService.findById(user.getCompany().getId(), false);
		return "/view/profile/my_company.xhtml";
	}
	
	public String mainForm() {
		return "/view/main.xhtml";
	}
	
	public String countryList() {
		return "/view/dictionary/country_list.xhtml";
	}
	
	public String faqList() {
		return "/view/faq/faq_list.xhtml";
	}
	
	public String docList() {
		return "/view/documents/documents.xhtml";
	}
	
	public String paymentList() {
		return "/view/payments/payments_list.xhtml";
	}
	
	public String helpList() {
		return "/view/help/help.xhtml";
	}
	
	public String mainData() {
		return "/view/profile/my_profile.xhtml";
	}
	
	public String mainDataCompany() {
		return "/view/profile/my_company.xhtml";
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Boolean getEditProfile() {
		return editProfile;
	}
	
	public void setEditProfile(Boolean editProfile) {
		this.editProfile = editProfile;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}

