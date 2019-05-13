package com.revature.credentials;

public class CredentialsTicket {
	private int reimb_type_id;
	private String reimb_description;
	private int reimb_author_id;
	public CredentialsTicket(int reimb_type_id, String reimb_description, int reimb_author_id, int reimb_amount) {
		super();
		this.reimb_type_id = reimb_type_id;
		this.reimb_description = reimb_description;
		this.reimb_author_id = reimb_author_id;
		this.reimb_amount = reimb_amount;
	}
	public int getReimb_author_id() {
		return reimb_author_id;
	}
	public void setReimb_author_id(int reimb_author_id) {
		this.reimb_author_id = reimb_author_id;
	}
	public CredentialsTicket() {
		super();
	}
	private int reimb_amount;
	public int getReimb_type_id() {
		return reimb_type_id;
	}
	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}
	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	@Override
	public String toString() {
		return "CredentialsTicket [reimb_type_id=" + reimb_type_id + ", reimb_description=" + reimb_description
				+ ", reimb_amount=" + reimb_amount + "]";
	}
	public int getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public CredentialsTicket(int reimb_type_id, String reimb_description, int reimb_amount) {
		super();
		this.reimb_type_id = reimb_type_id;
		this.reimb_description = reimb_description;
		this.reimb_amount = reimb_amount;
	}
}
