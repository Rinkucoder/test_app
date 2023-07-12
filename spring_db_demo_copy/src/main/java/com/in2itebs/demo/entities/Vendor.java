package com.in2itebs.demo.entities;

 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="vendor")

public class Vendor {

	@Id
	@Column(nullable=false, name="id") // It will change the column name of "code" as Id in db table
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")// It will use uuid generator will generate a long random string
    private String code;

	@Column(nullable=false, name="company_name") 
    private String companyName;

	@Column(nullable=false, name="contact_person") 
    private String contactPerson;

	@Column(nullable=false, name="first_name") 
    private String firstName;

	@Column(nullable=true, name="last_name") 
    private String lastName;

	@Column(nullable=false, name="status") 
    private String status;

	@Column(nullable=false, name="website") 
    private String website;

	@Column(nullable=true, name="email") 
    private String email;

	@Column(nullable=true, name="reg_date") 
    private Date regdate;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="vendor_id", referencedColumnName="id")
	private List<Address> addressess = new ArrayList<>();
	
    public List<Address> getAddressess() {
		return addressess;
	}

	public void setAddressess(List<Address> addressess) {
		this.addressess = addressess;
	}

	
	
	public String getCode() {

        return code;

    }

    public void setCode(String code) {

        this.code = code;

    }

    public String getCompanyName() {

        return companyName;

    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;

    }

    public String getContactPerson() {

        return contactPerson;

    }

    public void setContactPerson(String contactPerson) {

        this.contactPerson = contactPerson;

    }

    public String getFirstName() {

        return firstName;

    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;

    }

    public String getLastName() {

        return lastName;

    }

    public void setLastName(String lastName) {

        this.lastName = lastName;

    }

    public String getStatus() {

        return status;

    }

    public void setStatus(String status) {

        this.status = status;

    }

    public String getWebsite() {

        return website;

    }

    public void setWebsite(String website) {

        this.website = website;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public Date getRegdate() {

        return regdate;

    }

    public void setRegdate(Date regdate) {

        this.regdate = regdate;

    }

    @Override

    public String toString() {

        return "Vendor [code=" + code + ", companyName=" + companyName + ", contactPerson=" + contactPerson

                + ", firstName=" + firstName + ", lastName=" + lastName + ", status=" + status + ", website=" + website

                + ", email=" + email + ", regdate=" + regdate + "]";

    }

    public Vendor() {

        super();

//        this.code = "VENDI1";
//
//        this.companyName = "IBM";
//
//        this.contactPerson = "Bob";
//
//        this.firstName = "Suraj";
//
//        this.lastName = "Mohapatra";
//
//        this.status ="A" ;
//
//        this.website = "www.ibm.co.us";
//
//        this.email = "Suraj123@gmail.com";
//
//        this.regdate = new Date() ;

    }

	public Vendor(String code, String companyName, String contactPerson, String firstName, String lastName,
			String status, String website, String email, Date regdate) {
		super();
		this.code = code;
		this.companyName = companyName;
		this.contactPerson = contactPerson;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.website = website;
		this.email = email;
		this.regdate = regdate;
	}
    

    

    

    

 

    

    

}