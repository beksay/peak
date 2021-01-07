package org.peakcoin.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.peakcoin.beans.FilterExample;
import org.peakcoin.beans.InequalityConstants;
import org.peakcoin.domain.Country;
import org.peakcoin.domain.Oblast;
import org.peakcoin.enums.SortEnum;
import org.peakcoin.service.CountryService;
import org.peakcoin.service.OblastService;

/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@SuppressWarnings("cdi-not-passivation-capable")
@Named
@ConversationScoped
public class CountrySelector implements Serializable {

	private static final long serialVersionUID = -6366013603565093628L;
	private Country country;
	private Oblast oblast;
	
	@EJB
	private CountryService countryService;
	@EJB
	private OblastService oblastService;
	
	@Inject
	private Conversation conversation;
	
	public CountrySelector() {}
	
	@PostConstruct
	public void initialize() {
		if(conversation.isTransient()) conversation.begin();
	}
	
    public void closeConversation() {
		if(!conversation.isTransient()) conversation.end();
	}
    
    public List<Country> getCountryList() {
		List<FilterExample> examples = new ArrayList<>();
		return countryService.findByExample(0, 10, SortEnum.ASCENDING, examples, "id");
	}
    
    public List<Oblast> getOblastList(Country country) {
		List<FilterExample> examples = new ArrayList<>();
		if(country !=null) {
			examples.add(new FilterExample("country", country, InequalityConstants.EQUAL)); 
		}else {
			return Collections.emptyList(); 
		}
		return oblastService.findByExample(0, 20, SortEnum.ASCENDING, examples, "id");
	}
    
    public List<Oblast> getLocalOblastList() {
		List<FilterExample> examples = new ArrayList<>();
		examples.add(new FilterExample("country.id", 1, InequalityConstants.EQUAL)); 
		return oblastService.findByExample(0, 20, SortEnum.ASCENDING, examples, "id");
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Oblast getOblast() {
		return oblast;
	}
	
	public void setOblast(Oblast oblast) {
		this.oblast = oblast;
	}
	
}
