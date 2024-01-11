package com.dto;

public class admin {
	private int aid;
	private String aname;
	private long amob;
	private String amail;
	private String apass;

	public admin() {
		super();

	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public long getAmob() {
		return amob;
	}

	public void setAmob(long amob) {
		this.amob = amob;
	}

	public String getAmail() {
		return amail;
	}
   
	public void setAmail(String amail) {
		this.amail = amail;
	}

	public String getApass() {
		return apass;
	}

	public void setApass(String apass) {
		this.apass = apass;
	}

	@Override
	public String toString() {
		return "admin [aid=" + aid + ", aname=" + aname + ", amob=" + amob + ", amail=" + amail + ", apass=" + apass
				+ "]";
	}

}
