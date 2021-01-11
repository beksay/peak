package org.peakcoin.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 
 * @author Kuttubek Aidaraliev
 *
 */

@Entity
@Table(name="hiking_person")
public class HikingPerson extends AbstractEntity<Integer>  {
	private static final long serialVersionUID = 1L;
	private Person person;
	private Date date;
	private Hiking hiking;
	
	@ManyToOne
	@JoinColumn (name="person_id")
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@ManyToOne
	@JoinColumn (name="hiking_id")
	public Hiking getHiking() {
		return hiking;
	}
	
	public void setHiking(Hiking hiking) {
		this.hiking = hiking;
	}

}