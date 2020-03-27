package dept.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dept.model.dao.DepartmentDAO;
import dept.model.vo.DepartmentVO;

public class DepartmentService {
	
	public ArrayList<DepartmentVO> selectList() {
		Connection con = getConnection();
		ArrayList<DepartmentVO> list = new DepartmentDAO().selectList(con);
		close(con);
		return list;
	}

	public void insert(DepartmentVO vo) {
		Connection con = getConnection();
		new DepartmentDAO().insert(con, vo);
		close(con);
	}

	public DepartmentVO selectOne(int deptNo) {
		Connection con = getConnection();
		DepartmentVO list = new DepartmentDAO().se1ectOne(con, deptNo);
		close(con);
		return list;
	}

	public void update(DepartmentVO vo) {
		Connection con = getConnection();
		new DepartmentDAO().update(con, vo);
		close(con);
	}

	public void delete(int deptNo) {
		Connection con = getConnection();
		new DepartmentDAO().delete(con, deptNo);
		close(con);
	}
}
