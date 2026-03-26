package model;

import java.sql.Timestamp;

public class Post implements java.io.Serializable{
	
	private int id;	
	private String userId;	
	private String content;	
	private Timestamp createdAt;
	
//  今後使用予定
//  private String userName;
//  private String title;
//  private int likeCount;
//  private String comment;
	
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
/*
	public String getUserName(){
	    return userName;
	}
	public String getTitle(){
        return title;
    } 
    public int getLikeCount(){
        return likeCount;
    }    
    public String getComment(){
       return comment;
    }   
*/
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
/*
    public void setUserName( String userName){
        this.userName=userName;
    }
    public void setTitle( String title){
        this.title=title;
    }
    public void setlikeCount( int likeCount){
        this.likeCount=likecCont;
    }
    public void setComment( String comment){
        this.comment=comment;
    }
 */

}
