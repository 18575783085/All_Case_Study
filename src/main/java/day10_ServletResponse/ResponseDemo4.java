package day10_ServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * response功能三：定时刷新
 * @author Administrator
 *
 */
public class ResponseDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 实现定时刷新
		 * 通过Refresh头可以实现多少秒之后跳转到指定的位置
		 * 提示用户将要进行定时刷新
		 */
		response.setHeader("Refresh", "3;url="+request.getContextPath()+"/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
