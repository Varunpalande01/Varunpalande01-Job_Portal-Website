//package com.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import com.entity.User;
//
//public class UserDAO {
//	private Connection conn;
//
//	public UserDAO(Connection conn) {
//		super();
//		this.conn = conn;
//	}
//
//	public boolean addUser(User u) {
//		boolean f = false;
//		try {
//			String sql = "insert into user(name,email,password,qualification,role) values(?,?,?,?,?)";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, u.getName());
//			ps.setString(2, u.getEmail());
//			ps.setString(3, u.getPassword());
//			ps.setString(4, u.getQualification());
//			
//			ps.setString(5, "user");
//
//			int i = ps.executeUpdate();
//			if (i == 1) {
//				f = true;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		return f;
//	}
//	public boolean updateUser(User u) {
//	    boolean f = false;
//	    try {
//	        String sql = "UPDATE user SET name=?, email=?, password=?, qualification=? where id=?";
//	        PreparedStatement ps = conn.prepareStatement(sql);
//	        ps.setString(1, u.getName());
//	        ps.setString(2, u.getEmail());
//	        ps.setString(3, u.getPassword());
//	        ps.setString(4, u.getQualification());
//	        ps.setInt(5, u.getId());
//
//	        int i = ps.executeUpdate();
//	        if (i == 1) {
//	            f = true;
//	        }
//
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return f;
//	}
//
//	public User login(String em, String psw) {
//		User u = null;
//		try {
//			String sql = "select * from user where email=? and password=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, em);
//			ps.setString(2, psw);
//
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				u = new User();
//				u.setId(rs.getInt(1));
//				u.setName(rs.getString(2));
//				u.setEmail(rs.getString(3));
//				u.setPassword(rs.getString(4));
//				u.setQualification(rs.getString(5));
//				
//				u.setRole(rs.getString(6));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return u;
//
//	}
//	public boolean deleteUser(int id) {
//	    boolean success = false;
//
//	    String sql = "DELETE FROM user WHERE id = ?";
//	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
//	        ps.setInt(1, id);
//
//	        int rowsAffected = ps.executeUpdate();
//	        success = (rowsAffected > 0);
//	    } catch (Exception e) {
//	        e.printStackTrace(); // Log in production
//	    }
//
//	    return success;
//	}
//
//
//
//}
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAO {

    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    // ================== ADD USER ==================
    public boolean addUser(User u) {
        boolean f = false;
        try {
            String sql = "INSERT INTO users(name,email,password,qualification,role) VALUES(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getQualification());
            ps.setString(5, u.getRole());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    // ================== LOGIN ==================
    public User login(String email, String password) {
        User u = null;
        try {
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setQualification(rs.getString("qualification"));
                u.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    // ================== UPDATE USER ==================
    public boolean updateUser(User u) {
        boolean f = false;
        try {
            String sql = "UPDATE users SET name=?, email=?, password=?, qualification=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getQualification());
            ps.setInt(5, u.getId());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    // ================== DELETE USER ==================
    public boolean deleteUser(int id) {
        boolean f = false;
        try {
            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
