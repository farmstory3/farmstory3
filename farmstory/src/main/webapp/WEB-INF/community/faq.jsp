<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>자주묻는질문</title>
</head>
<link rel="stylesheet" href="../css/header.css" />
<link rel="stylesheet" href="../css/community.css" />
<link rel="stylesheet" href="../css/style.css" />
<link rel="stylesheet" href="../css/footer.css" />
<body>
	<div class="header-wrapper">
		<div class="header-logo-box">
			<div class="header-logo"  onclick="location.href='/farmstory'">
				<div class="logo-link-box">
					<div class="logo-link">
						<div>
							<a href="/farmstory">Home</a>
						</div>
						<div>|</div>
						<div>
							<a href="/farmstory/login.do">로그인</a>
						</div>
						<div>|</div>
						<div>
							<a href="/farmstory/register.do">회원가입</a>
						</div>
						<div>|</div>
						<div>
							<a href="/farmstory/community/qna.html">고객센터</a>
						</div>
					</div>
				</div>
				<div class="logo-add-box"></div>
			</div>
		</div>
		<div class="header-gubun-box">
			<div class="menu-1"></div>
			<div class="menu-2"></div>
			<div class="menu-3"></div>
			<div class="menu-4"></div>
			<div class="menu-5"></div>
		</div>
		<div class="header-menu-box">
			<div>
				<div class="menu-gubun"></div>
				<a href="/farmstory/introduction/hello.do">
					<div class="menu-1 menu"></div>
				</a>
			</div>
			<div>
				<div class="menu-gubun"></div>
				<a href="../market/list.html">
					<div class="menu-2 menu">
						<img src="../images/head_menu_badge.png" alt="badge">
					</div>
				</a>
			</div>
			<div>
				<div class="menu-gubun"></div>
				<a href="/farmstory/article/list.do?group=croptalk&cate=story">
					<div class="menu-3 menu"></div>
				</a>
			</div>
			<div>
				<div class="menu-gubun"></div>
				<a href="/farmstory/article/list.do?group=event&cate=info">
					<div class="menu-4 menu"></div>
				</a>
			</div>
			<div>
				<div class="menu-gubun"></div>
				<a href="/farmstory/article/list.do?group=community&cate=notice">
					<div class="menu-5 menu"></div>
				</a>
			</div>
		</div>
		<div class="header-bottom-img">
			<div class="header-bottom-comm">
				<img src="../images/sub_top_tit5.png" alt="community">
			</div>
		</div>
	</div>
	<div class="main-wrapper">
		<div class="sidebar-box">
			<div class="sidebar-logo-box">
				<div class="sidebar-logo"></div>
			</div>
			<div class="sidebar-bg-box">
				<a href="/farmstory/article/list.do?group=community&cate=notice"/>
					<div class="sidebar-item _01"></div>
				</a> <a href="/farmstory/article/list.do?group=community&cate=menu"/>
					<div class="sidebar-item _02"></div>
				</a> <a href="/farmstory/article/list.do?group=community&cate=chef"/>
					<div class="sidebar-item _03"></div>
				</a> <a href="/farmstory/article/list.do?group=community&cate=qna"/>
					<div class="sidebar-item _04"></div>
				</a> <a href="/farmstory/article/list.do?group=community&cate=faq"/>
					<div class="sidebar-item _05 _ov"></div>
				</a>
			</div>
		</div>
		<div class="sidebar-gubun-box"></div>

		<div class="main-box">
			<div class="main-title-box">
				<div class="main-title _05"></div>
				<div class="main-nav-box">
					<div class="nav-icon-box">
						<div class="nav-icon"></div>
					</div>
					<div class="nav-tit-1">Home</div>
					<div class="nav-latest-icon">></div>
					<div class="nav-tit-2">커뮤니티</div>
					<div class="nav-latest-icon">></div>
					<div class="nav-tit-3">자주묻는질문</div>
				</div>
			</div>
			<div class="main-gubun-box"></div>
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
						<a href="/jboard/article/list.do?pg=${pageGroup.start-1}"
							class="prev">이전</a>
					</c:if>
					<c:forEach var="i" begin="${pageGroup.start}"
						end="${pageGroup.end}">
						<a href="/jboard/article/list.do?pg=${i}"
							class="num ${currentPage == i ? 'current':'off'}">${i}</a>
					</c:forEach>
					<c:if test="${pageGroup.end < lastPageNum}">
						<a href="/jboard/article/list.do?pg=${pageGroup.end+1}"
							class="next">다음</a>
					</c:if>
				</div>

				<!-- 글쓰기 버튼 -->
				<a href="/jboard/article/write.do" class="btnWrite">글쓰기</a>
			</section>
		</div>
	</div>
	<div class="footer-wrapper">
		<div class="footer-gubun-box"></div>
		<div class="footer-main-box">
			<div class="footer-logo-box"></div>
			<div class="footer-info-box">
				<div class="footer-info-detail">
					<div>(주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제
						2013-팜스토리구-123호 / 벤처기업확인 서울지방중소기업청 제 012345678-9-01234호</div>
					<div>등록번호 팜스토리01234 (2013.04.01) / 발행인 : 홍길동</div>
					<div>대표 : 홍길동 / 이메일 : email@mail.mail / 전화 : 01) 234-5678 /
						경기도 성남시 잘한다구 신난다동 345</div>
					<div class="footer-info-copywriter">Copyright(C)홍길동 All
						rights reserved.</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		document.querySelectorAll(".sidebar-item").forEach(function(item) {
			item.addEventListener("click", function() {
				document.querySelectorAll(".sidebar-item").forEach(function(i) {
					i.classList.remove("_ov");
				});
				this.classList.add("_ov");
			});
		});
	</script>
</body>
</html>
