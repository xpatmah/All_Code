package com.org.hibernate.sql.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USERTABLE")
public class UserDetails {
	//user when the primary key is the Object type
	//@EmbeddedId
	@Id
	@Column(name="ID")
	private int id;
	
	@Embedded
	@AttributeOverrides({@AttributeOverride(name="streat" , column=@Column(name="HOME_STREAT_ADDR")),
			@AttributeOverride(name="city" , column=@Column(name="HOME_CITY_ADDR")),
			@AttributeOverride(name="state" , column=@Column(name="HOME_STATE_ADDR")),
			@AttributeOverride(name="pincode" , column=@Column(name="HOME_PINCODE"))})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({@AttributeOverride(name="streat" , column=@Column(name="OFFICE_STREAT_ADDR")),
		@AttributeOverride(name="city" , column=@Column(name="OFFICE_CITY_ADDR")),
		@AttributeOverride(name="state" , column=@Column(name="OFFICE_STATE_ADDR")),
		@AttributeOverride(name="pincode" , column=@Column(name="OFFICE_PINCODE"))})
	private Address OfficeAddress;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@JoinTable(name="USER_STATUS" , 
			 joinColumns=@JoinColumn(name="USER_ID_FK") 
	)
	@GenericGenerator(name="increment-gen" , strategy="increment")
	@CollectionId(columns= {@Column(name="STATUS_ID")},generator="increment-gen",type=@Type(type="integer"))
	private Collection<Status> status = new ArrayList<>();
	
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//private int serogatkey;
	
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	@OneToOne
	@JoinColumn(name="DES_ID")
	private Description description;
	
	@Transient
	private String passportNo;
	
	@OneToMany
	@JoinTable(name="VEHICLE_TABLE", joinColumns= {@JoinColumn(name="USER_ID")},
	inverseJoinColumns= {@JoinColumn(name="VEHICLE_ID")})
	private Collection<Vehicle> vehicle = new ArrayList<>();

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public Collection<Status> getStatus() {
		return status;
	}
	public void setStatus(Collection<Status> status) {
		this.status = status;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return OfficeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		OfficeAddress = officeAddress;
	}
	
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
