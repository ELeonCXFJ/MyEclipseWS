package util.test;

import java.sql.SQLException;

import org.junit.Test;

import java.sql.*;

import cn.itcast.jdbc.JdbcUtils;

/*
 * jdbcutils用来获取Connection
 * 底层使用了c3p0连接池
 * mysql驱动必须
 */
public class JdbcUtilsTest {
	/*
	 * c3p0配置文件
	 * @trhows SQLException
	 */
	@Test
	public void testGetConnection() throws SQLException{
		Connection con = JdbcUtils.getConnection();//用getConnection()别导错包了, 是java.sql.Connection
		System.out.println(con);
		JdbcUtils.releaseConnection(con);//智能开关，好用啊~
		System.out.println(con.isClosed());
	}
	/*
	 * JdbcUtils还提供了与事务相关的功能
	 */
	
	@Test
	public void testTranscation(){
		try{
			JdbcUtils.beginTransaction();//开始事务
			//todo
			
			
			JdbcUtils.commitTransaction();//提交事务
		}catch(Exception e){
			try{
				JdbcUtils.rollbackTransaction();//回滚
			}catch(SQLException e1){	
			}
		}
	}
}
