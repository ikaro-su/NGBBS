package model;

import java.sql.Timestamp;

public class LateReason implements java.io.Serializable{
	
	private int id;
	private String name;
	private Timestamp date;
	private String reason;
	private int likeCount;
	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Timestamp getDate() {
		return date;
	}
	
	public String getReason() {
		return reason;
		
	}
	
	public int getLikeCount() {
		return likeCount;
	}
	
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setDate(Timestamp date){
		this.date=date;
	}
	
	public void setReason(String reason) {
		this.reason=reason;
		
	}
	
	public void setLikeCount(int likeCount) {
		this.likeCount=likeCount;
	}
}