package com.example.ctl;

import javax.mail.Address;
import javax.mail.Message;

public class EmailForm {

	private String subject;

	private Address from;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Address getFrom() {
		return from;
	}

	public void setFrom(Address from) {
		this.from = from;
	}

}
