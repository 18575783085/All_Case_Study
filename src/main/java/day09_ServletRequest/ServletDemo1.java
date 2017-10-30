package day09_ServletRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 获取请求的信息
 * @author Administrator
 *
 */
public class ServletDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//getRequestURI()：获取客户端的请求web应用中某一个servlet的路径
		String uri = request.getRequestURI();
		response.getWriter().write("请求的是一个web应用地址："+uri);
		
		//getRequestURL()：获取客户端的请求完整路径
		StringBuffer url = request.getRequestURL();
		response.getWriter().write("请求的是一个完整地址："+url);
		
		//getLocalAddr()：获取客户端的请求ip地址（是一个IPV6网络地址）
		String ip = request.getLocalAddr();
		
		//getLocalName()：获取客户端的请求主机名字
		String host = request.getLocalName();
		
		//getLocalPort()：获取客户端的请求端口
		int port = request.getLocalPort();
		
		response.getWriter().write(ip+","+host+","+port);
		
		//getContextPath()：获取web应用的虚拟目录（重点）
		String contextPath = request.getContextPath();
		response.getWriter().write("web应用虚拟目录："+contextPath);
		
		//getContentLength()：获取地址长度？
		int contentLength = request.getContentLength();
		response.getWriter().write(contentLength);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
