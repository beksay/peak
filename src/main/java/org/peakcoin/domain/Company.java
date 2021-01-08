package org.peakcoin.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "company")
public class Company extends AbstractEntity<Integer>{

    private static final long serialVersionUID = 1L;
    private String name;
    private String instagram;
    private String website; 
    private String phone;   
    private String phoneAdditional;
    private String account;
    private BigDecimal money;
    private Boolean requirement;
    private Date dateCreated;
    private Documents documents;
    
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public BigDecimal getMoney() {
		return money;
	}
	
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	public Boolean getRequirement() {
		return requirement;
	}
	
	public void setRequirement(Boolean requirement) {
		this.requirement = requirement;
	}

	@ManyToOne
	@JoinColumn(name = "documents_id")
	public Documents getDocuments() {
		return documents;
	}
	public void setDocuments(Documents documents) {
		this.documents = documents;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getInstagram() {
		return instagram;
	}
	
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	@Column(name = "phone_additional")
	public String getPhoneAdditional() {
		return phoneAdditional;
	}
	
	public void setPhoneAdditional(String phoneAdditional) {
		this.phoneAdditional = phoneAdditional;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_created")
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
