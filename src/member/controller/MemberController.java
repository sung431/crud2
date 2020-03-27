package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.model.service.DepartmentService;
import dept.model.vo.DepartmentVO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String menu = request.getParameter("menu");
		if(menu == null) menu = "listAll";
		
		if(menu.equals("listAll")) {
			ArrayList<MemberVO> list = new MemberService().selectList();
			request.setAttribute("list", list);
			
			RequestDispatcher view = request.getRequestDispatcher("views/member/memberList.jsp");
			view.forward(request, response);
		}
		
		else if(menu.equals("add")) {
			ArrayList<DepartmentVO> list = new DepartmentService().selectList();
			request.setAttribute("list", list);
			RequestDispatcher view = request.getRequestDispatcher("views/member/memberAdd.jsp");
			view.forward(request, response);
		}
		
		else if(menu.equals("insert")) {
			MemberVO vo = new MemberVO();
			vo.setDeptNo(Integer.parseInt(request.getParameter("dept_no")));
			vo.setMemberName(request.getParameter("member_name"));
			new MemberService().insert(vo);
			response.sendRedirect("member?menu=listAll");
		}
		
		else if(menu.equals("view")) {
			ArrayList<DepartmentVO> list = new DepartmentService().selectList();
			request.setAttribute("list", list);
			
			MemberVO vo = new MemberService().selectOne(Integer.parseInt(request.getParameter("member_no")));
			request.setAttribute("vo", vo);
			
			RequestDispatcher view = request.getRequestDispatcher("views/member/memberView.jsp");
			view.forward(request, response);
		}
		
		else if(menu.equals("update")) {
			MemberVO vo = new MemberVO();
			vo.setMemberNo(Integer.parseInt(request.getParameter("member_no")));
			vo.setDeptNo(Integer.parseInt(request.getParameter("dept_no")));
			vo.setMemberName(request.getParameter("member_name"));
			new MemberService().update(vo);
			
			response.sendRedirect("member?menu=listAll");
		}
		
		else if(menu.equals("delete")) {
			int memberNo = Integer.parseInt(request.getParameter("member_no"));
			new MemberService().delete(memberNo);
			
			response.sendRedirect("member?menu=listAll");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
