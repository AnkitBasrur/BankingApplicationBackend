package com.lti.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userDetails")
public class Account {

	@Id
	private String oldid;
	private String userTitle;
	private String userFirstname;
	private String userMiddlename;
	private String userLastname;
	private String userFathername;
	private String userMobileno;
	private String userEmailid;
	private String userAadharcard;
	private String userDob;
	private String userResidentialaddr;
	private String userPermanentaddr;
	private String userOccupationType;
	private String userGrossannualincome;
	private boolean userIsverified;
	private boolean userIslocked;
	private int counter;

	public Account() {
		super();
	}

	public Account(String oldid, String user_title, String user_firstname, String user_middlename, String user_lastname,
			String user_fathername, String user_mobileno, String user_emailid, String user_aadharcard, String user_dob,
			String user_residentialaddr, String user_permanentaddr, String user_occupation_type,
			String user_grossannualincome, boolean user_isverified, boolean user_islocked, int counter) {
		super();
		this.oldid = oldid;
		this.userTitle = user_title;
		this.userFirstname = user_firstname;
		this.userMiddlename = user_middlename;
		this.userLastname = user_lastname;
		this.userFathername = user_fathername;
		this.userMobileno = user_mobileno;
		this.userEmailid = user_emailid;
		this.userAadharcard = user_aadharcard;
		this.userDob = user_dob;
		this.userResidentialaddr = user_residentialaddr;
		this.userPermanentaddr = user_permanentaddr;
		this.userOccupationType = user_occupation_type;
		this.userGrossannualincome = user_grossannualincome;
		this.userIsverified = user_isverified;
		this.userIslocked = user_islocked;
		this.counter = counter;
	}

	public String getOldid() {
		return oldid;
	}

	public void setOldid(String oldid) {
		this.oldid = oldid;
	}

	public String getUserTitle() {
		return userTitle;
	}

	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}

	public String getUserFirstname() {
		return userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserMiddlename() {
		return userMiddlename;
	}

	public void setUserMiddlename(String userMiddlename) {
		this.userMiddlename = userMiddlename;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public String getUserFathername() {
		return userFathername;
	}

	public void setUserFathername(String userFathername) {
		this.userFathername = userFathername;
	}

	public String getUserMobileno() {
		return userMobileno;
	}

	public void setUserMobileno(String userMobileno) {
		this.userMobileno = userMobileno;
	}

	public String getUserEmailid() {
		return userEmailid;
	}

	public void setUserEmailid(String userEmailid) {
		this.userEmailid = userEmailid;
	}

	public String getUserAadharcard() {
		return userAadharcard;
	}

	public void setUserAadharcard(String userAadharcard) {
		this.userAadharcard = userAadharcard;
	}

	public String getUserDob() {
		return userDob;
	}

	public void setUserDob(String userDob) {
		this.userDob = userDob;
	}

	public String getUserResidentialaddr() {
		return userResidentialaddr;
	}

	public void setUserResidentialaddr(String userResidentialaddr) {
		this.userResidentialaddr = userResidentialaddr;
	}

	public String getUserPermanentaddr() {
		return userPermanentaddr;
	}

	public void setUserPermanentaddr(String userPermanentaddr) {
		this.userPermanentaddr = userPermanentaddr;
	}

	public String getUserOccupationType() {
		return userOccupationType;
	}

	public void setUserOccupationType(String userOccupationType) {
		this.userOccupationType = userOccupationType;
	}

	public String getUserGrossannualincome() {
		return userGrossannualincome;
	}

	public void setUserGrossannualincome(String userGrossannualincome) {
		this.userGrossannualincome = userGrossannualincome;
	}

	public boolean isUserIsverified() {
		return userIsverified;
	}

	public void setUserIsverified(boolean userIsverified) {
		this.userIsverified = userIsverified;
	}

	public boolean isUserIslocked() {
		return userIslocked;
	}

	public void setUserIslocked(boolean userIslocked) {
		this.userIslocked = userIslocked;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public String toString() {
		return "Account [oldid=" + oldid + ", userTitle=" + userTitle + ", userFirstname=" + userFirstname
				+ ", userMiddlename=" + userMiddlename + ", userLastname=" + userLastname + ", userFathername="
				+ userFathername + ", userMobileno=" + userMobileno + ", userEmailid=" + userEmailid
				+ ", userAadharcard=" + userAadharcard + ", userDob=" + userDob + ", userResidentialaddr="
				+ userResidentialaddr + ", userPermanentaddr=" + userPermanentaddr + ", userOccupationType="
				+ userOccupationType + ", userGrossannualincome=" + userGrossannualincome + ", userIsverified="
				+ userIsverified + ", userIslocked=" + userIslocked + ", counter=" + counter + "]";
	}

	
}