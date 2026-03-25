package model;
public class User implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
    private int userId;
    private String password;
    public User() {
    	
    }
    public User(int userId,String password) {
    	this.userId=userId;
    	this.password=password;
    }
    
    public int getUserId() {
        return userId;
    }
    public String getPassword() {
        return password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
}