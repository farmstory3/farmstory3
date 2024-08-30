<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Administrator::Member</title>
<link rel="stylesheet" href="/farmstory/css/adminmember.css">
</head>
<body>
	<jsp:include page="/layout/adminheader.jsp" />
	<main>
		<jsp:include page="/layout/adminsidebar.jsp" />
		<div id="section2_main">
			<div id="section2_title">회원상세정보</div>
			<div id="article_wrapper">
				<div id="article1">
					<table id="member_table">
						<tr>
							<th>아이디</th>
							<td>${member.uid}</td>
						</tr>
						<tr>
							<th>이름</th>
							<td>${member.name}</td>
						</tr>
						<tr>
							<th>별명</th>
							<td>${member.nick}</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${member.email}</td>
						</tr>
						<tr>
							<th>휴대폰</th>
							<td>${member.hp}</td>
						</tr>
						<tr>
							<th>등급</th>
							<td>
								<select name="role">
										<option value="등급">${member.role}</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>우편번호</th>
							<td>${member.zip}</td>
						</tr>
						<tr>
							<th>주소</th>
							<td>${member.addr1}</td>
						</tr>
						<tr>
							<th>상세주소</th>
							<td>${member.addr2}</td>
						</tr>
						<tr>
							<th>사용자IP</th>
							<td>${member.regip}</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td>${member.regDate}</td>
						</tr>
						<tr>
							<th>탈퇴일</th>
							<td>${member.leaveDate}</td>
						</tr>
						<tr>
							<th>포인트</th>
							<td>${member.point}</td>
						</tr>
						<tr>
							<th>목록</th>
							<td><a href="/farmstory/admin/member.do">[목록]</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="/layout/adminfooter.jsp" />
</body>
</html>
