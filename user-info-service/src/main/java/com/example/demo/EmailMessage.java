package com.example.demo;

public class EmailMessage {
	private String to_address;
	private String subject;
	private String body;
	private long expirytimeofotp;
	private String otpemail;
	
	
	public String getTo_address() {
		return to_address;
	}
	public void setTo_address(String to_address) {
		this.to_address = to_address;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getOtpemail() {
		return otpemail;
	}
	public void setOtpemail(String otpemail) {
		this.otpemail = otpemail;
	}
	public long getExpirytimeofotp() {
		return expirytimeofotp;
	}
	public void setExpirytimeofotp(long expirytimeofotp) {
		this.expirytimeofotp = expirytimeofotp;
	}	
}
