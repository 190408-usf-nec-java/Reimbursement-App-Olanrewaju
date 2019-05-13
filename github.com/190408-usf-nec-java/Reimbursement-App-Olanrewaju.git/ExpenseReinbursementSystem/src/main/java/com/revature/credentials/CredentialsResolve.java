package com.revature.credentials;

public class CredentialsResolve {
	private int reimb_status_id;
	private int reimb_id;
	public CredentialsResolve(int reimb_status_id, int reimb_id) {
		super();
		this.reimb_status_id = reimb_status_id;
		this.reimb_id = reimb_id;
	}
	public CredentialsResolve() {
		super();
	}
	public int getReimb_status_id() {
		return reimb_status_id;
	}
	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}
	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}
	@Override
	public String toString() {
		return "CredentialsResolve [reimb_status_id=" + reimb_status_id + ", reimb_id=" + reimb_id + "]";
	}
	
}
