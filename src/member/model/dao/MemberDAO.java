package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static common.JDBCTemplate.*;

import member.model.vo.MemberVO;

public class MemberDAO {
	
	public ArrayList<MemberVO> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="SELECT member_no, member_name, dept_name " + 
				"FROM member m " + 
				"JOIN department d " + 
				"ON m.dept_no = d.dept_no " + 
				"ORDER BY member_no DESC;";
		
		ArrayList<MemberVO> list = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MemberVO vo = new MemberVO();
				
				vo.setMemberNo(rset.getInt("member_no"));
				vo.setMemberName(rset.getString("member_name"));
				vo.setDeptName(rset.getString("dept_name"));
				
				list.add(vo);
			};
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public void insert(Connection con, MemberVO vo) {
		PreparedStatement pstmt = null;
		String query="INSERT INTO member(member_name, dept_no) "
				+ "VALUES(?, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getMemberName());
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

	public MemberVO selectOne(Connection con, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="SELECT member_no, member_name, m.dept_no, dept_name " + 
				"FROM member m " + 
				"JOIN department d " + 
				"ON m.dept_no = d.dept_no " + 
				"WHERE member_no = ?;";
		
		MemberVO vo = new MemberVO();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				vo.setMemberNo(rset.getInt("member_no"));
				vo.setMemberName(rset.getString("member_name"));
				vo.setDeptNo(rset.getInt("dept_no"));
				vo.setDeptName(rset.getString("dept_name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return vo;
	}

	public void update(Connection con, MemberVO vo) {
		PreparedStatement pstmt = null;
		String query="UPDATE member SET member_name = ?, dept_no = ? "
				+ "WHERE member_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getMemberName());
			pstmt.setInt(2, vo.getDeptNo());
			pstmt.setInt(3, vo.getMemberNo());
			
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

	public void delete(Connection con, int memberNo) {
		PreparedStatement pstmt = null;
		String query="DELETE FROM member "
				+ "WHERE member_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			
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
