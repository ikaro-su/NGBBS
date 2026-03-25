package model;

import java.sql.Timestamp;

public class Post implements java.io.Serializable{
	
	//投稿ID
	private int id;
	
	//投稿者ID
	private String userId;
	
	//投稿本文
	private String content;
	
	//投稿日時
	private Timestamp createdAt;
	
	public int getId() {
		return id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getContent() {
		return content;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setUserId(String userId) {
		this.userId=userId;
	}
	
	public void setContent(String content) {
		this.content=content;
	}
	
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt=createdAt;
	}
	
}
