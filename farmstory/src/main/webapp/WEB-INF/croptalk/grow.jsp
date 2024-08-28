<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>텃밭가꾸기</title>
</head>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/grow.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/footer.css">

<body>
	<jsp:include page="/layout/_header.jsp" />
	<div class="main-wrapper">
		<div class="sidebar-box">
			<div class="sidebar-logo-box">
				<div class="sidebar-logo"></div>
			</div>
			<div class="sidebar-bg-box">
				<a href="/farmstory/article/list.do?group=croptalk&cate=story">
					<div class="sidebar-item _01"></div>
				</a> <a href="/farmstory/article/list.do?group=croptalk&cate=grow">
					<div class="sidebar-item _02 _ov"></div>
				</a> <a href="/farmstory/article/list.do?group=croptalk&cate=school">
					<div class="sidebar-item _03"></div>
				</a>
			</div>
		</div>
		<div class="sidebar-gubun-box"></div>

		<div class="main-box">
			<div class="main-title-box">
				<div class="main-title"></div>
				<div class="main-nav-box">
					<div class="nav-icon-box">
						<div class="nav-icon"></div>
					</div>
					<div class="nav-tit-1">Home</div>
					<div class="nav-latest-icon">></div>
					<div class="nav-tit-2">농작물이야기</div>
					<div class="nav-latest-icon">></div>
					<div class="nav-tit-3">텃밭가꾸기</div>
				</div>
			</div>
			<div class="main-gubun-box"></div>
			<main>
				<section class="list">
					<h3>글목록</h3>
					<article>
						<table border="0">
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>날짜</th>
								<th>조회</th>
							</tr>
							<c:forEach var="article" items="${articles}">
								<tr>
									<td>${pageStartNum}</td>
									<td><a href="/jboard/article/view.do?no=${article.no}">${article.title}</a>&nbsp;[${article.comment}]</td>
									<td>${article.nick}</td>
									<td>${article.rdate}</td>
									<td>${article.hit}</td>
								</tr>
								<!-- 한번 반복할때마다 pageStartNum을 1씩 차감 -->
								<c:set var="pageStartNum" value="${pageStartNum-1}" />
							</c:forEach>
						</table>
					</article>

					<!-- 페이지 네비게이션 -->
					<div class="paging">
                    <c:if test="${pageGroup.start > 1}">
                    	<a href="/jboard/article/list.do?pg=${pageGroup.start - 1}" class="prev">이전</a>
	                </c:if>
	                <c:choose>
		                <c:when test="${pageGroup.end > pageLastNum}">
		                	<c:forEach var="i" begin="${pageGroup.start}" end="${pageLastNum}">
		                    	<a href="/jboard/article/list.do?pg=${i}" class="num ${currentPageNum == i ? 'current':'off'}">${i}</a>                
		                    </c:forEach>
		                </c:when>
		                <c:otherwise>
			                 <c:forEach var="i" begin="${pageGroup.start}" end="${pageGroup.end}">
		                    	<a href="/jboard/article/list.do?pg=${i}" class="num ${currentPageNum == i ? 'current':'off'}">${i}</a>                
		                    </c:forEach>
		                	 <a href="/jboard/article/list.do?pg=${pageGroup.end + 1}" class="next">다음</a>
		                </c:otherwise>
	               </c:choose>
                </div>

					<!-- 글쓰기 버튼 -->
					<a href="/farmstory/article/write.do" class="btnWrite">글쓰기</a>
				</section>
			</main>

		</div>

	</div>
	<jsp:include page="/layout/_footer.jsp" />	
</body>

</html>