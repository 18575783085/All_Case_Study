package day10_ServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * response功能二：请求重定向
 * @author Administrator
 *
 */
public class ResponseDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 实现请求重定向
		 * 通过302状态和Location响应头可以实现请求重定向
		 */
		response.setStatus(302);
		response.setHeader("location", request.getContextPath()+"/index.jsp");
		
		//相等于
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
