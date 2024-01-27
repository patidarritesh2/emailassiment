package com.example.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.ORSResponse;

@RestController
@RequestMapping(value = "User")
public class UserCtl {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	
	@GetMapping("readMail/{login}")
	public ORSResponse readMail(@PathVariable String login) {
		
		System.out.println("in read mail");

		ORSResponse res = new ORSResponse(true);

		Properties properties = new Properties();
		properties.setProperty("mail.store.protocol", "imaps");

		try {
			Session session = Session.getDefaultInstance(properties, null);
			Store store = session.getStore();
			store.connect("smtp.gmail.com", login, "fquvsizlzabmyfdb");

			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			List list = new ArrayList();
			Message[] messages = inbox.getMessages();
			for (Message message : messages) {
				EmailForm form = new EmailForm();
				form.setSubject(message.getSubject());
				form.setFrom(message.getFrom()[0]);
				list.add(form);
				// mails.put(message.getSubject(), message.getFrom()[0]);
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
			}
			inbox.close();
			store.close();
			// mails.put("list", list);
			res.addEmails(list);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return res;
	}
}
