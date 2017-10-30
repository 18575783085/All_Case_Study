package day09_ServletRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 创建第一个Servlet文件
 * @author Administrator
 *
 */
public class FirstServletDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 接收 GET 请求
		 */
		response.getWriter().write("第一个Servlet响应：GET method...");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 接收 POST 请求
		 */
		response.getWriter().write("第一个Servlet响应：POST method...");
	}

}
