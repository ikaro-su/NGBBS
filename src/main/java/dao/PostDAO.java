// コメントって一つの投稿に対して複数付くはずだから、
// post_idと一緒にコメントを保存するDBがいるよね

// 投稿を一覧表示するページを作るのか、
// 

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Post;
import model.User;


public class PostDAO extends DAO {
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
			post.setPost_id(rs.getInt("post_id"));
			post.setUser_name(rs.getString("user_name"));
			post.setTitle(rs.getString("title"));
			post.setContent(rs.getString("content"));
			post.setLike_count(rs.getInt("like_count"));
			post.setComment(rs.getString("comment"));
			post.setCreated_at(rs.getTimestamp("created_at"));
		}
		
		st.close();
		con.close();
		return post;
	}
	
	public Post searchAll() throws Exception {
		List<Post> posts = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("select * from post");
		st.setInt(1, post_id);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			post = new Post();
			post.setPost_id(rs.getInt("post_id"));
			post.setUser_name(rs.getString("user_name"));
			post.setTitle(rs.getString("title"));
			post.setContent(rs.getString("content"));
			post.setLike_count(rs.getInt("like_count"));
			post.setComment(rs.getString("comment"));
			post.setCreated_at(rs.getTimestamp("created_at"));
		}
		
		st.close();
		con.close();
		return post;
	}
	
	
	public void insert(User user) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement
				("insert into post(user_name, title, content, comment) values (?,?,?,?)");
		st.setString(1,user.getUser_name());
		st.setString(2,user.getTitle());
		st.setString(3,user.getContent());
		st.setString(4, user.getComment());
		ResultSet rs = st.executeQuery();
		
		st.close();
		con.close();
	}
}