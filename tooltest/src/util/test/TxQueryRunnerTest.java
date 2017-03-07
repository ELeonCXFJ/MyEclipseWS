package util.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.JdbcUtils;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * TxQueryRunner是QueryRunner的子类(依赖于commons-dbutils.jar)
 * 用法与QueryRunner相似
 * Tx类支持事务，它底层使用了JdbcUtils来获取连接。
 * 
 * 简化Jdbc的操作
 * QueryRunner3个主要方法：
 * update()--> insert,update,delete
 * query()-->select
 * batch()-->批处理
 */

public class TxQueryRunnerTest {
	/*
	 * 测试update()方法,执行insert、update、delete语句
	 */
	@Test
	public void testUpdate() throws SQLException{
		String sqlTest ="insert into userinfo(usr,sex,pwd,salt,role,state) value(?,?,?,?,?,?) " ;
		Object[] params = {"test1","0","111","BBB","0","1"};//sql语句参数
		QueryRunner qr = new TxQueryRunner();//没有提供连接池
		qr.update(sqlTest,params);//执行sql，不提供连接，qr内部会使用JdbcUtils来获取连接
	}
	
	/**
	 * 使用事务，连续插入2个
	 */
	@Test
	public void testUpdate2() throws Exception{
		try{
			JdbcUtils.beginTransaction();//开启事务
			//todo
			String sqlTest = "insert into userinfo(usr,sex,pwd,salt,role,state) value(?,?,?,?,?,?)";
			QueryRunner qr = new TxQueryRunner();
			Object[] params = {"test2","1","222","CCC","0","1"};//sql语句参数
			qr.update(sqlTest,params);
			
			if(false){
				throw new Exception();
			}
			
			params = new Object[] {"test3","0","333","DDD","0","1"};//sql语句参数
			qr.update(sqlTest,params);
			
			JdbcUtils.commitTransaction();//提交事务
		}catch(Exception e) {
			try{
				JdbcUtils.rollbackTransaction();//回滚事务
			}catch(SQLException e1){
			}
			throw e;
		}
	}
	
	
	/**
	 * 测试查询方法
	 * JDBC查询结果是ResultSet
	 * QueryRunner查询结果是通过ResultSet映射后的数据。
	 * 	*QueryRunner先执行select，得到ResultSet
	 * 	*再把Res转换为其他类型。
	 * 可以把ResultSet封装到javabean中
	 * 也可以把ResultSet封装到Map中
	 * 把结果集封装到object中（结果集是单行单列）
	 * 
	 * 
	 * 把结果集映射到Javabean中
	 * @throws SQLException 
	 */
	@Test
	public void testQuery1() throws SQLException{
		String sqlTest = "select * from userinfo where usr = ?";
		QueryRunner qr = new TxQueryRunner();
		/*
		 * 第二个参数类型为ResultSetHandler,它是一个借口，表示映射的结果类型
		 * 
		 * BeanHandler-->它是ResultSetHandler的实现类，它的作用是把结果集封装到Users对象中
		 */
		Users u = qr.query(sqlTest, new BeanHandler<Users>(Users.class),"admin");
		//映射必须数据库的字段名与类的属性名相同时才能进行 
		System.out.println(u);
		
	}
	
	/**
	 * 使用BeanListHandler测试映射多行结果集，即多个Javabean对象
	 * 一行结果集记录对应一个Javabean对象。
	 * @throws SQLException
	 */
	@Test
	public void testQuery2() throws SQLException{
		String sqlTest = "select * from userinfo";
		QueryRunner qr = new TxQueryRunner();
		/*
		 * 第二个参数类型为ResultSetHandler,它是一个借口，表示映射的结果类型
		 * 
		 * BeanListHandler-->它是ResultSetHandler的实现类
		 * 它的作用是把结果集封装到List<Users>对象中
		 */
		List<Users> u = qr.query(sqlTest, new BeanListHandler<Users>(Users.class));
		//映射必须数据库的字段名与类的属性名相同时才能进行 
		System.out.println(u);
	}
	
	/**
	 * 使用MapHandler，把单行结果集封装到Map中
	 * @throws SQLException
	 */
	@Test
	public void testQuery3() throws SQLException{
		String sqlTest = "select * from userinfo where uid=?";
		QueryRunner qr = new TxQueryRunner();

		Map<String,Object>  map = qr.query(sqlTest, new MapHandler(),"1");
		//映射必须数据库的字段名与类的属性名相同时才能进行 
		//要注意，如果查询数据库后出现重名字段，其键值将会被覆盖，所以一定要用别名，select *,id as userid from userinfo 这种形式。
		System.out.println(map);
	}
	
	/**
	 * 使用MapListHandler，把多行结果集封装到List<Map>中，即多个map
	 * 一行对应一个map，多行对应List<Map>
	 * @throws SQLException
	 */
	@Test
	public void testQuery4() throws SQLException{
		String sqlTest = "select * from userinfo";
		QueryRunner qr = new TxQueryRunner();

		List<Map<String,Object>>  mapList = qr.query(sqlTest, new MapListHandler());
		//映射必须数据库的字段名与类的属性名相同时才能进行 
		//要注意，如果查询数据库后出现重名字段，其键值将会被覆盖，所以一定要用别名，select *,id as userid from userinfo 这种形式。
		System.out.println(mapList);
	}
	
	/**
	 * 使用ScalarHandler，把单行单列结果集封装到object中（但是功能不局限于此）
	 * 
	 */
	@Test
	public void testQuery5() throws SQLException{
		String sqlTest = "select count(*) from userinfo";
		QueryRunner qr = new TxQueryRunner();

		Object obj = qr.query(sqlTest, new ScalarHandler());
		/*
		 * select count(*)结果一定是个整数
		 * >Integer
		 * >Long
		 * >BigInteger
		 * 不同的驱动，结果不同。
		 * 但是无论哪种类型都是Number。强制转换为Number一定不出错
		 */
		Number number = (Number)obj;
		int cnt = number.intValue();
		System.out.println(cnt);
	}
	
	/**
	 * 多表查询需要用MapHandler来处理
	 * 把结果集封装到map中
	 * 使用map生成Person对象
	 * 使用map生成address对象
	 * 把两个对象建立关系
	 * @throws SQLException
	 */
	@Test
	public void testQuery6() throws SQLException{
		String sqlTest = "select * from userinfo u,address a WHERE u.uid=a.aid AND u.uid=?";
		QueryRunner qr = new TxQueryRunner();
		Map map=qr.query(sqlTest, new MapHandler(),"1");
		/*
		 * 把Map中的数据分别分装到users和address类中
		 */
		Users user = CommonUtils.toBean(map, Users.class);
		Address addr = CommonUtils.toBean(map, Address.class);
		
		/*
		 * 建立类的关系
		 */
		user.setAddress(addr);
		
		System.out.println(user);
	}
}
