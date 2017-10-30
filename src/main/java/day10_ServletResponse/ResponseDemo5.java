package day10_ServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * response功能四：实现控制浏览器如何缓存一个资源
 * @author Administrator
 *
 */
public class ResponseDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.控制浏览器缓存时间字符串，缓存之后，每次访问的时间应该是一样的
		//Expires :-1(不缓存)
		response.setDateHeader("Expires", System.currentTimeMillis()+1000*60*60*24);
		/*
		 * Cache-Control :no-Cache(不缓存)
		 * 参数2：表示缓存5秒后动态刷新
		 */
		response.setHeader("Cache-Control", "max-age=5");
		
		//Pragma
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
