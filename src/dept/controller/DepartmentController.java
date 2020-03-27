package dept.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.model.dao.DepartmentDAO;
import dept.model.service.DepartmentService;
import dept.model.vo.DepartmentVO;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet(name = "dept", urlPatterns = { "/dept" })
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
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
			ArrayList<DepartmentVO> list = new DepartmentService().selectList();
			request.setAttribute("list", list);
			RequestDispatcher view = request.getRequestDispatcher("views/dept/deptList.jsp");
			view.forward(request, response);
		}
		
		else if(menu.equals("add")) {
			RequestDispatcher view = request.getRequestDispatcher("views/dept/deptAdd.jsp");
			view.forward(request, response);
		}
		
		else if(menu.equals("insert")) {
			DepartmentVO vo = new DepartmentVO();
			vo.setDeptName(request.getParameter("dept_name"));
			new DepartmentService().insert(vo);
			
			response.sendRedirect("dept?menu=listAll");
		}
		
		else if(menu.equals("view")) {
			DepartmentVO vo = new DepartmentService().selectOne(Integer.parseInt(request.getParameter("dept_no")));
			request.setAttribute("vo", vo);
			RequestDispatcher view = request.getRequestDispatcher("views/dept/deptView.jsp");
			view.forward(request, response);
		}
		
		else if(menu.equals("update")) {
			DepartmentVO vo = new DepartmentVO();
			vo.setDeptNo(Integer.parseInt(request.getParameter("dept_no")));
			vo.setDeptName(request.getParameter("dept_name"));
			new DepartmentService().update(vo);
			response.sendRedirect("dept?menu=listAll");
		}
		
		else if(menu.equals("delete")) {
			new DepartmentService().delete(Integer.parseInt(request.getParameter("dept_no")));
			response.sendRedirect("dept?menu=listAll");
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
