package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Post;
//import model.User;


public class PostDAO extends DAO {
	
	// 投稿を1件取得
	public Post searchPost(String user_name, int post_id)
	throws Exception {
		Post post = null;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement
				("select * from post where post_id = ?");
		st.setInt(1, post_id);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			post = new Post();
			post.setId(rs.getInt("Id"));
			post.setUserId("userId");
			post.setContent(rs.getString("content"));
			post.setCreatedAt(rs.getTimestamp("createdAt"));
			
//			post.setUser_name(rs.getString("user_name"));
//			post.setTitle(rs.getString("title"));
//			post.setLike_count(rs.getInt("like_count"));
//			post.setComment(rs.getString("comment"));
		}
		
		st.close();
		con.close();
		return post;
	}
	
	
	// 投稿の一覧を取得
	public List<Post> searchAll(Post post) throws Exception {
		List<Post> posts = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("select * from post");
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Post p = new Post();
			p.setId(rs.getInt("id"));
			p.setUserId(rs.getString("userId"));
			p.setContent(rs.getString("content"));
			p.setCreatedAt(rs.getTimestamp("createdAt"));
			posts.add(p);
			
//			p.setUser_name(rs.getString("user_name"));
//			p.setTitle(rs.getString("title"));
//			p.setLike_count(rs.getInt("like_count"));
//			p.setComment(rs.getString("comment"));			
		}
		
		st.close();
		con.close();
		return posts;
	}
	
	
	// 投稿するときのDB登録
	public void insert(int userId, String content) throws Exception {
	    Connection con = getConnection();

	    PreparedStatement st = con.prepareStatement(
	        "INSERT INTO post(user_id, content, created_at) VALUES(?, ?, CURRENT_TIMESTAMP)"
	    );
	    st.setInt(1, userId);
	    st.setString(2, content);
	    st.executeUpdate();

	    st.close();
	    con.close();
	}
}