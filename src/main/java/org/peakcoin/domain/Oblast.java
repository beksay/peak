package org.peakcoin.domain;

import javax.persistence.*;

/**
 * @author Kuttubek Aidaraliev
 */

@Entity
@Table(name = "oblast")
public class Oblast extends AbstractEntity<Integer> {

    private static final long serialVersionUID = -1716718384374303808L;
    private String name;
    private Country country;
    private String location;

    public Oblast() {
    }

    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
	}

    @ManyToOne
	@JoinColumn(name="country_id")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}