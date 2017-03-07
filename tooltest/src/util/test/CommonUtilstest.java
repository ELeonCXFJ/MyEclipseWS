package util.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.itcast.commons.CommonUtils;


/*
 * CommonUtils类测试
 * CommonUtils依赖的jar包：commons-beanutils.jar,commons-logging.jar
 * 
 */
public class CommonUtilstest {
	@Test
	/*
	 * 测试uuid()
	 * 返回32位字符串，不会重复
	 */
	public void testUuid(){
		String s= CommonUtils.uuid();
		System.out.println(s);
	}
	
	/*
	 * map映射到javabean
	 * map的key值要和javabean的属性一一对应
	 */
	@Test
	public void testToBean(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pid","123");
		map.put("pname", "xfj");
		map.put("age", "23");
		map.put("error", "error");//数据可能丢失但不会报错		
		Person p = CommonUtils.toBean(map, Person.class);
		System.out.println(p);
	}
}
