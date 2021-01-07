package org.peakcoin.domain;

import javax.persistence.*;

import org.peakcoin.enums.DocStatus;

/**
 * @author Kuttubek Aidaraliev
 */

@Entity
@Table(name = "documents")
public class Documents extends AbstractEntity<Integer> {

    private static final long serialVersionUID = -1716718384374303808L;
    private Attachment passport;
    private Attachment driverLicense;
    private Attachment carLicense;
    private DocStatus status;

	@ManyToOne
	@JoinColumn(name = "passport_id")
	public Attachment getPassport() {
		return passport;
	}

	public void setPassport(Attachment passport) {
		this.passport = passport;
	}

	@ManyToOne
	@JoinColumn(name = "driver_license_id")
	public Attachment getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(Attachment driverLicense) {
		this.driverLicense = driverLicense;
	}
	
	@ManyToOne
	@JoinColumn(name = "car_license_id")
	public Attachment getCarLicense() {
		return carLicense;
	}
	
	public void setCarLicense(Attachment carLicense) {
		this.carLicense = carLicense;
	}

	@Enumerated(EnumType.ORDINAL)
	public DocStatus getStatus() {
		return status;
	}

	public void setStatus(DocStatus status) {
		this.status = status;
	}

}