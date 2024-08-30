<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Administrator::Member</title>
<link rel="stylesheet" href="/farmstory/css/adminmember.css">
<script type="text/javascript">
    	
	    function selectAll(selectAllCheckbox) {
	        // member_table 테이블에서 모든 체크박스를 가져옴
	        const checkboxes = document.querySelectorAll('#member_table input[type="checkbox"][name="member"]');
	        
	        checkboxes.forEach((checkbox) => {
	            checkbox.checked = selectAllCheckbox.checked;
	        });
	    }
    
</script>

</head>
<body>
	<jsp:include page="/layout/adminheader.jsp" />
	<main>
		<jsp:include page="/layout/adminsidebar.jsp" />
		<div id="section2_main">
			<div id="section2_title">회원목록</div>
			<div id="article_wrapper">
				<div id="article1">
					<table id="member_table">
						<tr>
							<th><input type="checkbox" id="selectAll" onclick="selectAll(this)"></th>
							<th>아이디</th>
							<th>이름</th>
							<th>별명</th>
							<th>이메일</th>
							<th>휴대폰</th>
							<th>등급</th>
							<th>가입일</th>
							<th>확인</th>
						</tr>
						<c:forEach var="user" items="${users}">
							<tr>
								<td><input type="checkbox" name="member"></td>
								<td>${user.uid}</td>
								<td>${user.name}</td>
								<td>${user.nick}</td>
								<td>${user.email}</td>
								<td>${user.hp}</td>
								<td><select name="role">
										<option value="등급">${user.role}</option>
								</select></td>
								<td>${user.regDate}</td>
								<td><a href="#">[상세확인]</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div id="list_num">
					<c:if test="${pageGroup.start > 1}">
						<a href="/jboard/article/list.do?pg=${pageGroup.start-1}" class="prev">이전</a>
					</c:if>
					<c:forEach var="i" begin="${pageGroup.start}" end="${pageGroup.end}">
						<a href="/jboard/article/list.do?pg=${i}" class="num ${currentPage == i ? 'current':'off'}">${i}</a>
					</c:forEach>
					<c:if test="${pageGroup.end < lastPageNum}">
						<a href="/jboard/article/list.do?pg=${pageGroup.end+1}"	class="next">다음</a>
					</c:if>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="/layout/adminfooter.jsp" />
</body>
</html>
