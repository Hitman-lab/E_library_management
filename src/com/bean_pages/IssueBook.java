package com.bean_pages;

import java.sql.Date;

public class IssueBook {

	private String cellno;
	private String studentid;
	private String studentname;
	private long studentmobile;
	private Date issuedate;
	private String returnstatus;

	public IssueBook() {
	}

	public String getCellno() {
		return cellno;
	}

	public void setCellno(String cellno) {
		this.cellno = cellno;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public long getStudentmobile() {
		return studentmobile;
	}

	public void setStudentmobile(long studentmobile) {
		this.studentmobile = studentmobile;
	}

	public Date getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}

	public String getReturnstatus() {
		return returnstatus;
	}

	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}

}
