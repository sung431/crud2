package common;

import java.sql.*;

public class JDBCTemplate {
	
	public static Connection getConnection(){
		Connection con = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/first",
					"postgres",
					"root");
			
			
			con.setAutoCommit(false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return con;
	}
	
	public static void commit(Connection con){
		
		try {
			if(!con.isClosed()&& con!=null){
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con){
		try {
			if(!con.isClosed() && con!=null){
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(Connection con){
		try {
			if(!con.isClosed() && con!=null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		try {
			if(!stmt.isClosed() && stmt!=null){
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt){
		try {
			if(!pstmt.isClosed() && pstmt!=null){
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset){
		try {
			if(!rset.isClosed() && rset!=null){
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
