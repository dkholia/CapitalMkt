package com.dcsoft.capmkt.bo.transferobj;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.dcsoft.capmkt.annotations.Phone;

public class ChUserTO extends Model {

	private static final long serialVersionUID = -6553586406628842718L;
	@NotEmpty
	@Pattern(regexp="^[A-Za-z0-9]*$" ,message="LoginId Pattern not correct")
	private String loginid;
	
	@NotEmpty
	private String fname;
	
	private String mname;
	
	@NotEmpty
	private String lname;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotNull @Past
	private Date dob;
	
	@NotEmpty
	private String address1;
	
	private String address2;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String state;
	
	@NotEmpty
	private String country;
	
	@NotNull
	private Integer postalcode;
	
	@Phone
	private String contactNumber;
	
	@Email
	private String emailID;
	
	@NotEmpty
	private List<BigDecimal> groups = new ArrayList<BigDecimal>();
	
	@NotEmpty
	private List<BigDecimal> faps = new ArrayList<BigDecimal>();
	
	@NotEmpty
	private List<BigDecimal> daps = new ArrayList<BigDecimal>();
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(Integer postalcode) {
		this.postalcode = postalcode;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public List<BigDecimal> getGroups() {
		return groups;
	}
	public List<BigDecimal> getFaps() {
		return faps;
	}
	public List<BigDecimal> getDaps() {
		return daps;
	}
	public void setGroups(List<BigDecimal> groups) {
		this.groups = groups;
	}
	public void setFaps(List<BigDecimal> faps) {
		this.faps = faps;
	}
	public void setDaps(List<BigDecimal> daps) {
		this.daps = daps;
	}
}
