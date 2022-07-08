package com.Library_Management.MyApplication.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Lending {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transaction_id;
	private int bookid;
	private int userid;
	private boolean isreturned;
	@Basic
	private java.sql.Date issuedate;
	@Basic
	private java.sql.Date returndate;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public boolean isIsreturned() {
		return isreturned;
	}
	public void setIsreturned(boolean isreturned) {
		this.isreturned = isreturned;
	}
	public java.sql.Date getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(java.sql.Date issuedate) {
		this.issuedate = issuedate;
	}
	public java.sql.Date getReturndate() {
		return returndate;
	}
	public void setReturndate(java.sql.Date returndate) {
		this.returndate = returndate;
	}
	

}
