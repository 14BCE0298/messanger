package org.vishal.projects.messanger.model;

import java.util.Date;

public class Comment {
	private long id;
	private String comment;
	private Date created;
	private String author;
	
	public Comment() {
		
	}
	
	public Comment(long id, String comment, String author) {
		this.author = author;
		this.created = new Date();
		this.id = id;
		this.comment = comment;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
