package util.test;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;

import org.junit.Test;

import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

/**
 * 测试MailUtils，作用是发邮件
 * 底层依赖的是javamail：mail.jar,activition.jar
 */

public class MailUtilsTest {
	@Test
	/**
	 * 发邮件
	 */
	public void send() throws MessagingException, IOException{
		/*
		 * 1、 登录邮件服务器
		 * 	MailUtils.createSession(svrip,user,psw);
		 * 2、创建邮件对象
		 * 	发件人、收件人、主题、正文
		 * 3、发送邮件
		 * 	需要第一步得到的session和第二步的对象
		 * MailUtils简化了发邮件的流程
		 */
		Session session = MailUtils.createSession("smtp.163.com", "15021587045", "50650150");
		Mail mail = new Mail("15021587045@163.com","328967282@qq.com","测试邮件","<a href='http://www.baidu.com'>百度</a>");
		MailUtils.send(session, mail);
	}
}
