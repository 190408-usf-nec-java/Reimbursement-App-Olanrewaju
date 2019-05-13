package com.revature.credentials;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.sql.Blob;

public class ReimbursementData {
	private LinkedList<Integer> reimb_id;
	private LinkedList<Integer> reimb_amount;
	private LinkedList<Timestamp> reimb_submitted;
	private LinkedList<Timestamp> reimb_resolved;
	private LinkedList<String> reimb_description;
	private LinkedList<Blob> Reimb_receipt;
	private int reim_author;
	private LinkedList<Integer> reim_resolver;
	private LinkedList<Integer> reim_status_id;
	private String reimb_firstname;
	private String reimb_lastname;
	private LinkedList<String> reimb_status;
	private LinkedList<String> reimb_type;
	private LinkedList<Integer> reim_type_id;
	private LinkedList<String> reimb_firstnameLink;
	private LinkedList<String> reimb_lastnameLink;
	private int ers_user_id;
	private LinkedList<Integer> reim_authorLink;
	
	
	
	public LinkedList<Integer> getReim_authorLink() {
		return reim_authorLink;
	}
	public void setReim_authorLink(LinkedList<Integer> reim_authorLink) {
		this.reim_authorLink = reim_authorLink;
	}
	public ReimbursementData(LinkedList<Timestamp> reimb_resolved, LinkedList<String> reimb_description,
			LinkedList<Blob> reimb_receipt, int reim_author, LinkedList<Integer> reim_resolver,
			LinkedList<Integer> reim_status_id, String reimb_firstname, String reimb_lastname,
			LinkedList<String> reimb_status, LinkedList<String> reimb_type, LinkedList<Integer> reim_type_id,
			LinkedList<String> reimb_firstnameLink, LinkedList<String> reimb_lastnameLink, int ers_user_id,
			LinkedList<Integer> reim_authorLink) {
		super();
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		Reimb_receipt = reimb_receipt;
		this.reim_author = reim_author;
		this.reim_resolver = reim_resolver;
		this.reim_status_id = reim_status_id;
		this.reimb_firstname = reimb_firstname;
		this.reimb_lastname = reimb_lastname;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
		this.reim_type_id = reim_type_id;
		this.reimb_firstnameLink = reimb_firstnameLink;
		this.reimb_lastnameLink = reimb_lastnameLink;
		this.ers_user_id = ers_user_id;
		this.reim_authorLink = reim_authorLink;
	}
	public int getErs_user_id() {
		return ers_user_id;
	}
	public void setErs_user_id(int ers_user_id) {
		this.ers_user_id = ers_user_id;
	}
	public ReimbursementData(LinkedList<Timestamp> reimb_submitted, LinkedList<Timestamp> reimb_resolved,
			LinkedList<String> reimb_description, LinkedList<Blob> reimb_receipt, int reim_author,
			LinkedList<Integer> reim_resolver, LinkedList<Integer> reim_status_id, String reimb_firstname,
			String reimb_lastname, LinkedList<String> reimb_status, LinkedList<String> reimb_type,
			LinkedList<Integer> reim_type_id, LinkedList<String> reimb_firstnameLink,
			LinkedList<String> reimb_lastnameLink, int ers_user_id) {
		super();
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		Reimb_receipt = reimb_receipt;
		this.reim_author = reim_author;
		this.reim_resolver = reim_resolver;
		this.reim_status_id = reim_status_id;
		this.reimb_firstname = reimb_firstname;
		this.reimb_lastname = reimb_lastname;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
		this.reim_type_id = reim_type_id;
		this.reimb_firstnameLink = reimb_firstnameLink;
		this.reimb_lastnameLink = reimb_lastnameLink;
		this.ers_user_id = ers_user_id;
	}
	public LinkedList<String> getReimb_firstnameLink() {
		return reimb_firstnameLink;
	}
	public void setReimb_firstnameLink(LinkedList<String> reimb_firstnameLink) {
		this.reimb_firstnameLink = reimb_firstnameLink;
	}
	public LinkedList<String> getReimb_lastnameLink() {
		return reimb_lastnameLink;
	}
	public void setReimb_lastnameLink(LinkedList<String> reimb_lastnameLink) {
		this.reimb_lastnameLink = reimb_lastnameLink;
	}
	public ReimbursementData(LinkedList<Integer> reimb_amount, LinkedList<Timestamp> reimb_submitted,
			LinkedList<Timestamp> reimb_resolved, LinkedList<String> reimb_description, LinkedList<Blob> reimb_receipt,
			int reim_author, LinkedList<Integer> reim_resolver, LinkedList<Integer> reim_status_id,
			String reimb_firstname, String reimb_lastname, LinkedList<String> reimb_status,
			LinkedList<String> reimb_type, LinkedList<Integer> reim_type_id, LinkedList<String> reimb_firstnameLink,
			LinkedList<String> reimb_lastnameLink) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		Reimb_receipt = reimb_receipt;
		this.reim_author = reim_author;
		this.reim_resolver = reim_resolver;
		this.reim_status_id = reim_status_id;
		this.reimb_firstname = reimb_firstname;
		this.reimb_lastname = reimb_lastname;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
		this.reim_type_id = reim_type_id;
		this.reimb_firstnameLink = reimb_firstnameLink;
		this.reimb_lastnameLink = reimb_lastnameLink;
	}
	public ReimbursementData(LinkedList<Integer> reimb_id, LinkedList<Integer> reimb_amount,
			LinkedList<Timestamp> reimb_submitted, LinkedList<Timestamp> reimb_resolved,
			LinkedList<String> reimb_description, LinkedList<Blob> reimb_receipt, int reim_author,
			LinkedList<Integer> reim_resolver, LinkedList<Integer> reim_status_id, String reimb_firstname,
			String reimb_lastname, LinkedList<String> reimb_status, LinkedList<String> reimb_type,
			LinkedList<Integer> reim_type_id) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		Reimb_receipt = reimb_receipt;
		this.reim_author = reim_author;
		this.reim_resolver = reim_resolver;
		this.reim_status_id = reim_status_id;
		this.reimb_firstname = reimb_firstname;
		this.reimb_lastname = reimb_lastname;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
		this.reim_type_id = reim_type_id;
	}
	public LinkedList<Integer> getReim_type_id() {
		return reim_type_id;
	}
	public void setReim_type_id(LinkedList<Integer> reim_type_id) {
		this.reim_type_id = reim_type_id;
	}
	public LinkedList<String> getReimb_status() {
		return reimb_status;
	}
	public void setReimb_status(LinkedList<String> reimb_status) {
		this.reimb_status = reimb_status;
	}
	public LinkedList<String> getReimb_type() {
		return reimb_type;
	}
	public void setReimb_type(LinkedList<String> reimb_type) {
		this.reimb_type = reimb_type;
	}
	public String getReimb_firstname() {
		return reimb_firstname;
	}
	public void setReimb_firstname(String reimb_firstname) {
		this.reimb_firstname = reimb_firstname;
	}
	public String getReimb_lastname() {
		return reimb_lastname;
	}
	public void setReimb_lastname(String reimb_lastname) {
		this.reimb_lastname = reimb_lastname;
	}
	public ReimbursementData(LinkedList<Integer> reimb_amount, LinkedList<Timestamp> reimb_submitted,
			LinkedList<Timestamp> reimb_resolved, LinkedList<String> reimb_description, LinkedList<Blob> reimb_receipt,
			int reim_author, LinkedList<Integer> reim_resolver, String reimb_firstname,
			String reimb_lastname) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.Reimb_receipt = reimb_receipt;
		this.reim_author = reim_author;
		this.reim_resolver = reim_resolver;
		this.reimb_firstname = reimb_firstname;
		this.reimb_lastname = reimb_lastname;
	}
	
	public ReimbursementData(LinkedList<Integer> reimb_amount, LinkedList<Timestamp> reimb_submitted,
			LinkedList<Timestamp> reimb_resolved, LinkedList<String> reimb_description, LinkedList<Blob> reimb_receipt,
			int reim_author, LinkedList<Integer> reim_resolver) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.Reimb_receipt = reimb_receipt;
		this.reim_author = reim_author;
		this.reim_resolver = reim_resolver;
	}
	public ReimbursementData() {
		super();
	}
	public LinkedList<Integer> getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(LinkedList<Integer> reimb_id) {
		this.reimb_id = reimb_id;
	}
	public LinkedList<Integer> getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(LinkedList<Integer> reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public LinkedList<Timestamp> getReimb_submitted() {
		return reimb_submitted;
	}
	public void setReimb_submitted(LinkedList<Timestamp> reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}
	public LinkedList<Timestamp> getReimb_resolved() {
		return reimb_resolved;
	}
	public void setReimb_resolved(LinkedList<Timestamp> reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}
	public LinkedList<String> getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(LinkedList<String> reimb_description) {
		this.reimb_description = reimb_description;
	}
	public LinkedList<Blob> getReimb_receipt() {
		return Reimb_receipt;
	}
	public void setReimb_receipt(LinkedList<Blob> reimb_receipt) {
		this.Reimb_receipt = reimb_receipt;
	}
	public int getReim_author() {
		return reim_author;
	}
	public void setReim_author(int reim_author) {
		this.reim_author = reim_author;
	}
	public LinkedList<Integer> getReim_resolver() {
		return reim_resolver;
	}
	public void setReim_resolver(LinkedList<Integer> reim_resolver) {
		this.reim_resolver = reim_resolver;
	}
	public LinkedList<Integer> getReim_status_id() {
		return reim_status_id;
	}
	public void setReim_status_id(LinkedList<Integer> reim_status_id) {
		this.reim_status_id = reim_status_id;
	}
	@Override
	public String toString() {
		return "ReimbursementData [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", Reimb_receipt=" + Reimb_receipt + ", reim_author=" + reim_author + ", reim_resolver="
				+ reim_resolver + ", reim_status_id=" + reim_status_id + ", reimb_firstname=" + reimb_firstname
				+ ", reimb_lastname=" + reimb_lastname + ", reimb_status=" + reimb_status + ", reimb_type=" + reimb_type
				+ ", reim_type_id=" + reim_type_id + ", reimb_firstnameLink=" + reimb_firstnameLink
				+ ", reimb_lastnameLink=" + reimb_lastnameLink + ", ers_user_id=" + ers_user_id + ", reim_authorLink="
				+ reim_authorLink + "]";
	}
	
}
