package com.appspot.authagentpro;
import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.json.*;;

@PersistenceCapable(detachable="true")
public class Application {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long formId;
	
	
	@Persistent private String type = "Offline";
	@Persistent	private String poId;
	@Persistent	private String districtId;
	@Persistent	private String service;
	@Persistent	private String surname;
	@Persistent	private String name;
	@Persistent	private boolean isNameChanged=false;
	@Persistent	private String previousName;
	@Persistent	private String sex;
	@Persistent	private String dob;
	@Persistent	private String pob;
	@Persistent	private String pobDistrict;
	@Persistent	private String qualification;
	@Persistent	private String profession;
	@Persistent	private String visibleMark;
	@Persistent	private String height;
	@Persistent	private String[] address = new String[2];
	@Persistent	private String[] permAddress = new String[2];
	@Persistent	private String residingSince;
	@Persistent	private String phone;
	@Persistent	private String mob;
	@Persistent	private String email;
	@Persistent	private String maritalStatus;
	@Persistent	private String spouse;
	@Persistent	private String father;
	@Persistent	private String mother;
	@Persistent	private boolean isAddChange;
	@Persistent	private String[] from = new String[1];
	@Persistent	private String[] fromYear = new String[1];
	@Persistent	private String[] to = new String[1];
	@Persistent	private String[] toYear = new String[1];
	@Persistent	private String[] prevAdd1 = new String[2];
	@Persistent	private String[] prevAdd2 = new String[2];
	@Persistent	private boolean isDD=false;
	@Persistent	private String ddNo;
	@Persistent	private String ddDate;
	@Persistent	private String bank;
	@Persistent	private boolean isRenew=false;
	@Persistent	private String oldPassportNo;
	@Persistent	private String issueDate;
	@Persistent	private String placeOfIssue;
	@Persistent	private String oldFileNo;
	@Persistent	private String expiry;
	//Admin Fields
	@Persistent	private String fileNo="Not Submitted";
	@Persistent	private String onlineFileNo="";
	@Persistent	private String agent;
	@Persistent	private String subAgent;
	@Persistent	private String loggedBy;
	@Persistent	private Date loggedAt = new Date();
	@Persistent	private Date submittedAt;
	@Persistent	private String submittedBy;
	@Persistent private String lastUpdatedBy;
	@Persistent private Date lastUpdated;
	@Persistent private boolean deleted=false;
	
	
	public long getFormId() {
		return formId;
	}
	public void setFormId(long formId) {
		this.formId = new Long(formId);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if (type.length() == 1)	this.type = type;
	}

	public String getPoId() {
		return poId;
	}
	public void setPoId(String po) {
		if(po.length() == 3) this.poId = po;
	}
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String district) {
		if(district.length() < 4) this.districtId = district;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		if(service.length() <= 2) this.service = service;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		if(surname.length()<50) this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.length()<50) this.name = name;
	}
	public boolean getIsNameChanged() {
		return isNameChanged;
	}
	public void setIsNameChanged(boolean isNameChanged) {
		this.isNameChanged = isNameChanged;
	}
	public String getPreviousName() {
		return previousName;
	}
	public void setPreviousName(String previousName) {
		if(previousName.length()<50) this.previousName = previousName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = ""+sex;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		if(dob.length()<20) this.dob = dob;
	}
	public String getPob() {
		return pob;
	}
	public void setPob(String pob) {
		if(pob.length()<50) this.pob = pob;
	}
	public String getPobDistrict() {
		return pobDistrict;
	}
	public void setPobDistrict(String pobDistrict) {
		if(pobDistrict.length()<50) this.pobDistrict = pobDistrict;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		if(qualification.length()<50) this.qualification = qualification;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		if(profession.length()<50) this.profession = profession;
	}
	public String getVisibleMark() {
		return visibleMark;
	}
	public void setVisibleMark(String visibleMark) {
		if(visibleMark.length()<50) this.visibleMark = visibleMark;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		if(height.length()<= 3) this.height = height;
	}
	public String getResidingSince() {
		return residingSince;
	}
	public void setResidingSince(String string) {
		if(string.length()<= 20) this.residingSince = string;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		if(phone.length()<= 20) this.phone = phone;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		if(mob.length()<= 20) this.mob = mob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email.length()<= 50) this.email = email;
	}
	public String[] getPermAddress() {
		return permAddress;
	}
	public void setPermAddress(String[] peradd) {
		if(peradd[0].length()+peradd[1].length()+peradd[2].length() <= 250) this.permAddress = peradd;
	}
	public String[] getAddress() {
		return address;
	}
	public void setAddress(String[] add) {
		if(add[0].length()+add[1].length()+add[2].length() <= 250) this.address = add;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(char maritalStatus) {
		this.maritalStatus = ""+maritalStatus;
	}
	public String getSpouse() {
		return spouse;
	}
	public void setSpouse(String spouse) {
		if(spouse.length()<= 50) this.spouse = spouse;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		if(father.length()<= 50) this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		if(mother.length()<= 50) this.mother = mother;
	}
	public boolean getIsAddChange() {
		return isAddChange;
	}
	public void setIsAddChange(boolean isAddChange) {
		this.isAddChange = isAddChange;
	}
	public String[] getFrom() {
		return from;
	}
	public void setFrom(String[] from) {
		this.from = from;
	}
	public String[] getTo() {
		return to;
	}
	public void setTo(String[] to) {
		this.to = to;
	}
	public String[] getPrevAdd1() {
		return prevAdd1;
	}
	public void setPrevAdd1(String[] prevAdd1) {
		if(prevAdd1[0].length()+prevAdd1[1].length()+prevAdd1[2].length() < 500)
		this.prevAdd1 = prevAdd1;
	}
	public String[] getPrevAdd2() {
		return prevAdd2;
	}
	public void setPrevAdd2(String[] prevAdd2) {
		if(prevAdd2[0].length()+prevAdd2[1].length()+prevAdd2[2].length() < 500)
		this.prevAdd2 = prevAdd2;
	}
	public boolean getIsDD() {
		return isDD;
	}
	public void setIsDD(boolean isDD) {
		this.isDD = isDD;
	}
	public String getDdNo() {
		return ddNo;
	}
	public void setDdNo(String ddNo) {
		if(ddNo.length() < 10) this.ddNo = ddNo;
	}
	public String getDdDate() {
		return ddDate;
	}
	public void setDdDate(String ddDate) {
		if(ddDate.length() < 20) this.ddDate = ddDate;
	}
	public boolean isRenew() {
		return isRenew;
	}
	public void setIsRenew(boolean isRenew) {
		this.isRenew = isRenew;
	}
	public String getOldPassportNo() {
		return oldPassportNo;
	}
	public void setOldPassportNo(String oldPassportNo) {
		if(oldPassportNo.length() < 20) this.oldPassportNo = oldPassportNo;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		if(issueDate.length() < 20) this.issueDate = issueDate;
	}
	public String getPlaceOfIssue() {
		return placeOfIssue;
	}
	public void setPlaceOfIssue(String placeOfIssue) {
		if(placeOfIssue.length() < 50) this.placeOfIssue = placeOfIssue;
	}
	public String getOldFileNo() {
		return oldFileNo;
	}
	public void setOldFileNo(String oldFileNo) {
		if(oldFileNo.length() < 20) this.oldFileNo = oldFileNo;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		if(expiry.length() < 20) this.expiry = expiry;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		if(fileNo.length() < 20) this.fileNo = fileNo;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getSubAgent() {
		return subAgent;
	}
	public void setSubAgent(String subAgent) {
		this.subAgent = subAgent;
	}
	public String getLoggedBy() {
		return loggedBy;
	}
	public void setLoggedBy(String loggedBy) {
		this.loggedBy = loggedBy;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public Date getLoggedAt() {
		return loggedAt;
	}
	public void setLoggedAt(Date loggedAt) {
		this.loggedAt = loggedAt;
	}
	public Date getSubmittedAt() {
		return submittedAt;
	}
	public void setSubmittedAt(Date submittedAt) {
		this.submittedAt = submittedAt;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String[] getFromYear() {
		return fromYear;
	}
	public void setFromYear(String[] fromYear) {
		this.fromYear = fromYear;
	}
	public String[] getToYear() {
		return toYear;
	}
	public void setToYear(String[] toYear) {
		this.toYear = toYear;
	}
	public String getOnlineFileNo() {
		return onlineFileNo;
	}
	public void setOnlineFileNo(String onlineFileNo) {
		this.onlineFileNo = onlineFileNo;
	}
	public String getSubmittedBy() {
		return submittedBy;
	}
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	/*public String toString(){
		return new JSONObject(this).toString();
	}*/
}
