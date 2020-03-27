package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static common.JDBCTemplate.*;

import member.model.dao.MemberDAO;
import member.model.vo.MemberVO;

public class MemberService {
	
	public ArrayList<MemberVO> selectList() {
		Connection con = getConnection();
		ArrayList<MemberVO> list = new MemberDAO().selectList(con);
		close(con);
		return list;
	}

	public void insert(MemberVO vo) {
		Connection con = getConnection();
		new MemberDAO().insert(con, vo);
		close(con);
	}

	public MemberVO selectOne(int memberNo) {
		Connection con = getConnection();
		MemberVO vo = new MemberDAO().selectOne(con, memberNo);
		close(con);
		return vo;
	}

	public void update(MemberVO vo) {
		Connection con = getConnection();
		new MemberDAO().update(con, vo);
		close(con);
	}

	public void delete(int memberNo) {
		Connection con = getConnection();
		new MemberDAO().delete(con, memberNo);
		close(con);
	}

}
