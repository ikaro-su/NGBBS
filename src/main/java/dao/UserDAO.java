package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDAO extends DAO {
	public User search(String login_id, String password)
	throws Exception {
		User user = null;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement
				("select * from users where login_id = ? and password = ?");
		st.setString(1, login_id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			user = new User();
			user.setUserId(rs.getInt("userId"));
			user.setPassword(rs.getString("password"));
			
//			user.setUser_id(rs.getInt("user_id"));
//			user.setLogin_id(rs.getString("login_id"));
//			user.setUsername(rs.getString("user_name"));
//			user.setRole(rs.getString("role"));
		}
		
		st.close();
		con.close();
		return user;
	}
}