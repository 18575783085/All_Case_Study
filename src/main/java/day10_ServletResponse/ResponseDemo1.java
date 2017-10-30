package day10_ServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * response功能一：向客户端浏览器发送数据(getOutputStream)
 * @author Administrator
 *
 */
public class ResponseDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//getOutputStream
		/*
		 * 服务器端进行编码使用的码表：GBK
		 * 浏览器客户端进行解码时使用的码表：GBK
		 */
		response.getOutputStream().write("send a response".getBytes());
		response.getOutputStream().println();
		response.getOutputStream().write("send a response,国庆节".getBytes());
		
		//发送数据时如果指定了使用UTF-8字符集
		response.getOutputStream().write("send a response,国庆节快乐".getBytes("UTF-8"));
		
		//通知浏览器使用UTF-8来接收数据：Content-Type
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
