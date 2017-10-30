package day10_ServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * response功能一：向客户端浏览器发送数据(getWrite)
 * @author Administrator
 *
 */
public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//getWrite
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		/*
		 * 不指定字符集的情况下（默认）
		 * 服务器发送数据使用的编码：ISO-8859-1
		 * 浏览器接收数据使用的（系统平台）编码：GBK
		 */
		response.getWriter().write("send a response123");
		response.getWriter().println();
		response.getWriter().write("send a response123,中秋节");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
