package day03_c3p0pool;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * 获取元数据
 * 元数据：数据库、表、列的定义信息
 * @author Administrator
 *
 */
public class MetaDataDemo {

	public static void main(String[] args) {
		//connDemo();
		//preparedStatementDemo();
		resultSetDemo();
	}
	/**
	 * 获取连接数据库元数据各种参数
	 */
	public static void connDemo(){
		Connection conn = null;
		try {
			//1.获取数据库连接
			conn = DaoUtil.getConnection();
			//2.获取数据元对象
			DatabaseMetaData connMetaData = conn.getMetaData();
			
			//3.获取数据库的url路径
			String sqlUrl = connMetaData.getURL();
			System.out.println("数据库的URl路径："+sqlUrl);
			
			//4.获取连接当前数据库管理系统的用户名
			String userName = connMetaData.getUserName();
			System.out.println("数据库用户名："+userName);
			
			//5.1.获取数据库驱动程序的名称
			String driverName = connMetaData.getDriverName();
			System.out.println("驱动名称："+driverName);
			//5.2.驱动版本
			String driverVersion = connMetaData.getDriverVersion();
			System.out.println("驱动版本："+driverVersion);
			
			//6.getPrimaryKeys???

			//7.获取所有表:getTables()???
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DaoUtil.close(conn, null, null);
		}
	}
	
	/**
	 * 获取传输器元数据的各种参数
	 */
	public static void preparedStatementDemo(){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			//1.获取数据库连接
			conn = DaoUtil.getConnection();
			//2.编写sql语句
			String sql = "insert into exam_ozy " +
					"(name,chinese,math,english) " +
					"values" +
					"(?,?,?,?)";
			//3.预编译sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, "黄忠");
			ps.setDouble(2, 80);
			ps.setDouble(3, 90);
			ps.setDouble(4, 85);
			ps.executeUpdate();
			
			//4.获取传输器元数据
			ParameterMetaData parameterMetaData = ps.getParameterMetaData();
			
			//5.获取指定参数的个数
			int parameterCount = parameterMetaData.getParameterCount();
			System.out.println("参数的个数："+parameterCount);
			
			//6.获取指定参数的特定于数据库的类型名称
			String parameterTypeName = parameterMetaData.getParameterTypeName(parameterCount);
			System.out.println("类型名称："+parameterTypeName);
			
			//7.获取指定参数的sql类型
			int parameterType = parameterMetaData.getParameterType(parameterCount);
			System.out.println("sql类型："+parameterType);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DaoUtil.close(conn, ps, null);
		}
	}
	
	/**
	 * 获取结果集元数据的各种参数
	 */
	public static void resultSetDemo(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DaoUtil.getConnection();
			
			String sql = "select * from exam_ozy";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			//创建结果集元数据对象
			ResultSetMetaData rsMetaData = rs.getMetaData();
			
			//获取ResultSet对象的列数
			int columnCount = rsMetaData.getColumnCount();
			System.out.println("获取列数："+columnCount);
			
			//获取ResultSet对象指定列的名称
			String columnName = rsMetaData.getColumnName(columnCount);
			System.out.println("第5列："+columnName);
			System.out.println("第1列："+rsMetaData.getColumnName(1));
			System.out.println("第2列："+rsMetaData.getColumnName(2));
			System.out.println("第3列："+rsMetaData.getColumnName(3));
			System.out.println("第4列："+rsMetaData.getColumnName(4));
			//获取指定列的类型
			String columnTypeName = rsMetaData.getColumnTypeName(columnCount);
			System.out.println(columnName+":"+columnTypeName);
			System.out.println(rsMetaData.getColumnName(1)+":"+rsMetaData.getColumnTypeName(1));
			System.out.println(rsMetaData.getColumnName(2)+":"+rsMetaData.getColumnTypeName(2));
			System.out.println(rsMetaData.getColumnName(3)+":"+rsMetaData.getColumnTypeName(3));
			System.out.println(rsMetaData.getColumnName(4)+":"+rsMetaData.getColumnTypeName(4));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DaoUtil.close(conn, ps, rs);
		}
	}
}
