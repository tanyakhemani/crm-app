package com.crm.app.model;

public class Customer {
	private int cid;
	private String cfname;
	private String clname;
	private String email;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getCfname() {
		return cfname;
	}
	public void setCfname(String cfname) {
		this.cfname = cfname;
	}
	
	public String getClname() {
		return clname;
	}
	public void setClname(String clname) {
		this.clname = clname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cfname=" + cfname + ", clname=" + clname + ", email=" + email + "]";
	}
	
	
}
