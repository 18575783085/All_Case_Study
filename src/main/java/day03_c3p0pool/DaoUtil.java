package day03_c3p0pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库工具
 * @author Administrator
 *
 */
public class DaoUtil {
	
	private DaoUtil(){}
	/**
	 * 创建一个私有化的c3p0连接池实例对象
	 */
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	
	/**
	 * 获取C3P0连接池
	 * @return 返回C3P0连接池
	 */
	public static ComboPooledDataSource getPool(){
		return cpds;
	}
	
	/**
	 * 获取数据库连接
	 * @return 返回一个数据库连接
	 * @throws SQLException 获取连接失败
	 */
	public static Connection getConnection() throws SQLException{
		return cpds.getConnection();
	}
	
	
	/**
	 * 关闭数据库资源
	 * @param conn 归还数据库连接
	 * @param stat 关闭传输器
	 * @param rs 关闭返回结果集
	 */
	public static void close(Connection conn,Statement stat,ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				rs = null;
			}
		}
		
		if(stat != null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				stat = null;
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				conn = null;
			}
		}
	}
	

}
