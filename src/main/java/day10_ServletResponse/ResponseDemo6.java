package day10_ServletResponse;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * response：实现控制浏览器如何缓存一个资源
 * @author Administrator
 *
 */
public class ResponseDemo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//2.控制浏览器不要缓存一个资源
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("不要缓存资源："+new Date().toLocaleString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
