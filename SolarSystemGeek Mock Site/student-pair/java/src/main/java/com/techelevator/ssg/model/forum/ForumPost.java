package com.techelevator.ssg.model.forum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class ForumPost {
	private Long id;
	private String username;
	private String subject;
	private String message;
	private LocalDateTime datePosted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDatePosted() {
		String submitDate = datePosted.toString();
		String year = submitDate.substring(0, 4);
		String month = submitDate.substring(5, 7);
		int monthInt = Integer.parseInt(month);
		String monthName = Month.of(monthInt).name();
		String day = submitDate.substring(8, 10);
		String time = submitDate.substring(11, 19);
		return day + " " + monthName + " " + year + " at " + time;
	}

	public void setDatePosted(LocalDateTime datePosted) {
		this.datePosted = datePosted;
	}
}
