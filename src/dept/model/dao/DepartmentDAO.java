package dept.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static common.JDBCTemplate.*;

import dept.model.vo.DepartmentVO;

public class DepartmentDAO {

	public ArrayList<DepartmentVO> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="SELECT dept_no, dept_name " + 
				"FROM department " + 
				"ORDER BY dept_no;";
		
		ArrayList<DepartmentVO> list = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				DepartmentVO vo = new DepartmentVO();
				
				vo.setDeptName(rset.getString("dept_name"));
				vo.setDeptNo(rset.getInt("dept_no"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public void insert(Connection con, DepartmentVO vo) {
		PreparedStatement pstmt = null;
		String query="INSERT INTO department(dept_name) VALUES(?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getDeptName());
			
			if(pstmt.executeUpdate()>0){
				commit(con);
			}else {
				rollback(con);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}

	public DepartmentVO se1ectOne(Connection con, int deptNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="SELECT dept_name, dept_no FROM department WHERE dept_no = ?";
		
		DepartmentVO vo = new DepartmentVO();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, deptNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				vo.setDeptName(rset.getString("dept_name"));
				vo.setDeptNo(rset.getInt("dept_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return vo;
	}

	public void update(Connection con, DepartmentVO vo) {
		PreparedStatement pstmt = null;
		String query="UPDATE department SET dept_name = ? WHERE dept_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getDeptName());
			pstmt.setInt(2, vo.getDeptNo());
			
			if(pstmt.executeUpdate()>0){
				commit(con);
			}else {
				rollback(con);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}

	public void delete(Connection con, int deptNo) {
		PreparedStatement pstmt = null;
		String query="DELETE FROM department WHERE dept_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, deptNo);
			
			if(pstmt.executeUpdate()>0){
				commit(con);
			}else {
				rollback(con);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}


}
