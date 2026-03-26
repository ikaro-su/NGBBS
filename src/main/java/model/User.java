package model;

public class User implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	//ユーザーID
    private String userId;
    //パスワード
    private String password;
    
    public User() {
    	
    }
    
    public User(String userId,String password) {
    	this.userId=userId;
    	this.password=password;
    }
    
    public String getUserId() {
        return userId;
    }
    public String getPassword() {
        return password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
}