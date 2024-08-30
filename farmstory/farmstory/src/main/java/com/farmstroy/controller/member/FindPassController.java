package com.farmstroy.controller.member;
import java.io.BufferedReader;
/*비밀번호찾기 추가*/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstroy.Service.MemberService;
import com.farmstroy.Service.termsService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/findPass.do")
public class FindPassController extends HttpServlet{
	
	private static final long serialVersionUID = 4818082532605926530L;

	private Logger logger = LoggerFactory.getLogger(this.getClass()); 

	private MemberService service = MemberService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if(req.getParameter("type") != null) {
			// 데이터 수신
			String type = req.getParameter("type");
			String value = req.getParameter("value");
			logger.debug("type : " + type + ", value : " + value);

			// 조회하기
			int result = service.selectCountMember(type, value);

			if(type.equals("email") && result == 1) {
				// 이메일 인증번호 발송하기
				String code = service.sendEmailCode(value);

				// 세션 저장
				HttpSession session = req.getSession();
				session.setAttribute("authCode", code);
			}

			// JSON 생성
			JsonObject json = new JsonObject();
			json.addProperty("result", result);

			// JSON 출력
			PrintWriter writer = resp.getWriter();
			writer.print(json);
		} else {
			//로그인 상태가 아니면
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/findPass.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Javascript fetch함수 POST JSON 문자열 스트림 처리
		BufferedReader reader = req.getReader();
		StringBuilder requestBody = new StringBuilder();
		
		
		String line;
		while((line = reader.readLine()) != null){
			requestBody.append(line);
		}
		reader.close();

		// JSON 파싱
		Gson gson = new Gson();
		Properties prop = gson.fromJson(requestBody.toString(), Properties.class);
		String code = prop.getProperty("code");
		String email = prop.getProperty("email");
		String uid = service.select_uid(email);


		// 인증코드 일치 여부 확인
		HttpSession session = req.getSession();
		String authCode = (String) session.getAttribute("authCode");
		logger.debug("authCode : " + authCode);
	
		
		
		// JSON 생성 후 출력
		JsonObject json = new JsonObject();

		if(authCode.equals(code)) {			
			json.addProperty("result", 1);
			json.addProperty("uid", uid);
		}else {
			json.addProperty("result", 0);
		}

		PrintWriter writer = resp.getWriter();
		writer.print(json);
	}
}
