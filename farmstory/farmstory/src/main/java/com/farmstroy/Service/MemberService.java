package com.farmstroy.Service;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.farmstroy.DAO.member.MemberDAO;
import com.farmstroy.DTO.member.MemberDTO;



public enum MemberService{

	INSTANCE;
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	public String select_uid(String email) {
	      return dao.select_uid(email);
	}
	
	public String sendEmailCode(String email) {
		// 인증코드 생성
		int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
		
		// 이메일 기본정보
		String title = "jboard 인증번호 입니다.";
		String content = "<h1>인증코드는 " + code + "입니다.</h1>";
		String sender = "loveu9911111@gmail.com";
		String appPass = "tolk hjol morz szso"; // Google 앱 비밀번호
		
		// gmail SMTP 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		// gmail session 생성
		Session gmailSession = Session.getInstance(props, new Authenticator(){
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(sender, appPass);
			}
		});
		
		// 메일 발송
		Message message = new MimeMessage(gmailSession);
		
		try{
			message.setFrom(new InternetAddress(sender, "보내는사람", "UTF-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject(title);
			message.setContent(content, "text/html;charset=utf-8");
			Transport.send(message);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ""+code;
	}
	public int selectCountMember(String type, String value) {
		return dao.selectCountMember(type, value);
	}
	public void insertMember(MemberDTO dto) {
		dao.insertMember(dto);
	};
	public MemberDTO selectMember(String uid, String pass) {
		return dao.selectMember(uid, pass);
	};
	public MemberDTO selectMemberDetail(String uid) {
		return dao.selectMemberDetail(uid);
	};
	public List<MemberDTO> selectMembers() {
		return dao.selectMembers();
	};
	public List<MemberDTO> selectMembersList(int start) {
		return dao.selectMembersList(start);
	};
	public void updateUser(MemberDAO dto) {
		
	};
	public void deleteUser(String uid) {
		
	};
}

