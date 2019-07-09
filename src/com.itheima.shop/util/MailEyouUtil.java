package com.itheima.shop.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 发送邮件到易邮服务器工具类
* --------------------------------------------------------------------------------------------------
* 使用方法：
* 1_将本类放在com.itheima.shop.util包下
* 2_导入mail.jar到工程的/WEB-INF/lib/下
* 3_写一个Demo01类带main函数，调用
  MailEyouUtil.sendMail("发件人邮箱","收件人邮箱","邮件主题","支持HTML格式的邮件内容")
* 如：MailEyouUtil.sendMail("admin@abc.com","zhaojun@abc.com","测试一下","<b>你好</b>")
* --------------------------------------------------------------------------------------------------
*/
public final class MailEyouUtil {
	
	private final static Logger logger = LoggerFactory.getLogger(MailEyouUtil.class);
	
	public static final String FROM_ADMIN_EMAIL = "admin@mbm.com";
	/**
	 * 不允许new出工具类
	 */
	private MailEyouUtil(){}
	
	/**
	 * 发送邮件
	 * 参数一：发件人邮箱
	 * 参数二：收件人邮箱
	 * 参数三：邮件主题
	 * 参数四：邮件内容
	 */
	public static void sendMail(String fromEmail, String toEmail, String subject, String emailMsg)  {
		//1_建立Java程序与易邮邮件服务器的连接对象
		Properties props = new Properties();
		props.put("mail.smtp.host", "127.0.0.1");//易邮邮件服务器中SMTP服务器的域名或IP
		Session session = Session.getInstance(props,null);
		
		//2_创建一封邮件
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipient(RecipientType.TO, new InternetAddress(toEmail));//收件人邮箱
			message.setSubject(subject);//主题
			message.setContent(emailMsg, "text/html;charset=UTF-8");//内容和格式编码
			//3_发送邮件
			Transport.send(message);
			logger.info("发送成功，from:"+fromEmail+",to:"+toEmail+",subject:"+subject+",emailMsg:"+emailMsg);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("发送失败，from:"+fromEmail+",to:"+toEmail+",subject:"+subject+",emailMsg:"+emailMsg+",error:"+e.getMessage());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("发送失败，from:"+fromEmail+",to:"+toEmail+",subject:"+subject+",emailMsg:"+emailMsg+",error:"+e.getMessage());
		}//发件人邮箱
		
	}
	
}








