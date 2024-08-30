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
						<c:forEach var="member" items="${members}">
							<tr>
								<td><input type="checkbox" name="member" value="${member.uid}"></td>
								<td>${member.uid}</td>
								<td>${member.name}</td>
								<td>${member.nick}</td>
								<td>${member.email}</td>
								<td>${member.hp}</td>
								<td><select name="role">
										<option value="등급">${member.role}</option>
								</select></td>
								<td>${member.regDate}</td>
								<td><a href="/farmstory/admin/memberDetail.do?uid=${member.uid}">[상세확인]</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="list_num">
                    <c:if test="${pageGroup.start > 1}">
                    	<a href="/farmstory/admin/member.do?pg=${pageGroup.start - 1}" class="prev">이전</a>
	                </c:if>
	                <c:choose>
		                <c:when test="${pageGroup.end > pageLastNum}">
		                	<c:forEach var="i" begin="${pageGroup.start}" end="${pageLastNum}">
		                    	<a href="/farmstory/admin/member.do?pg=${i}" class="num ${currentPageNum == i ? 'current':'off'}">${i}</a>                
		                    </c:forEach>
		                </c:when>
		                <c:otherwise>
			                 <c:forEach var="i" begin="${pageGroup.start}" end="${pageGroup.end}">
		                    	<a href="/farmstory/admin/member.do?pg=${i}" class="num ${currentPageNum == i ? 'current':'off'}">${i}</a>                
		                    </c:forEach>
		                	 <a href="/farmstory/admin/member.do?pg=${pageGroup.end + 1}" class="next">다음</a>
		                </c:otherwise>
	               </c:choose>
                </div>
			</div>
		</div>
	</main>
	<jsp:include page="/layout/adminfooter.jsp" />
</body>
</html>
