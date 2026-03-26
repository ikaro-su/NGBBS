package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDAO extends DAO {
	public User findUser(String userId, String password)
	throws Exception {
		User user = null;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement
				("select * from users where userId = ? and password = ?");
		st.setString(1, userId);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			user = new User();
			user.setUserId(rs.getString("userId"));
			user.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return user;
	}
}