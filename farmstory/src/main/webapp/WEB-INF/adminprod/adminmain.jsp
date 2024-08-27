<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrator::Main</title>
<link rel="stylesheet" href="/farmstory/css/adminmain.css">
</head>
<body>
	<jsp:include page="/layout/adminheader.jsp" />
	<main>
		<jsp:include page="/layout/adminsidebar.jsp" />
		<div id="section2_main">
          <div id="section2_title">관리자 메인</div>
          <div id="article_wrapper">
            <div id="article1">
              <div class="table_heading" id="prod_heading">
                <a id="prod_now">상품현황</a>
                <a href="#" id="prod_more">+ 더보기</a>
              </div>
              <table id="prod_table">
                <tr>
                  <th>상품번호</th>
                  <th>상품명</th>
                  <th>구분</th>
                  <th>가격</th>
                  <th>재고</th>
                  <th>등록일</th>
                </tr>
                <tr>
                  <td>1011</td>
                  <td>사과 500g</td>
                  <td>과일</td>
                  <td>4,000원</td>
                  <td>100</td>
                  <td>2023-01-01</td>
                </tr>
                <tr>
                  <td>1011</td>
                  <td>사과 500g</td>
                  <td>과일</td>
                  <td>4,000원</td>
                  <td>100</td>
                  <td>2023-01-01</td>
                </tr>
                <tr>
                  <td>1011</td>
                  <td>사과 500g</td>
                  <td>과일</td>
                  <td>4,000원</td>
                  <td>100</td>
                  <td>2023-01-01</td>
                </tr>
              </table>
            </div>
            <div id="article2">
              <div class="table_heading" id="order_heading">
                <a id="order_now">주문현황</a>
                <a href="#" id="order_more">+ 더보기</a>
              </div>
              <table id="order_table">
                <tr>
                  <th>주문번호</th>
                  <th>상품명</th>
                  <th>판매가격</th>
                  <th>수량</th>
                  <th>배송비</th>
                  <th>합계</th>
                  <th>주문자</th>
                  <th>주문일</th>
                </tr>
                <tr>
                  <td>1011</td>
                  <td>사과 500g</td>
                  <td>4,000원</td>
                  <td>2개</td>
                  <td>3,000원</td>
                  <td>8,000원</td>
                  <td>홍길동</td>
                  <td>2023-01-01</td>
                </tr>
                <tr>
                  <td>1011</td>
                  <td>사과 500g</td>
                  <td>4,000원</td>
                  <td>2개</td>
                  <td>3,000원</td>
                  <td>8,000원</td>
                  <td>홍길동</td>
                  <td>2023-01-01</td>
                </tr>
                <tr>
                  <td>1011</td>
                  <td>사과 500g</td>
                  <td>4,000원</td>
                  <td>2개</td>
                  <td>3,000원</td>
                  <td>8,000원</td>
                  <td>홍길동</td>
                  <td>2023-01-01</td>
                </tr>
              </table>
            </div>
            <div id="article3">
              <div class="table_heading" id="user_heading">
                <a id="user_now">회원현황</a>
                <a href="#" id="user_more">+ 더보기</a>
              </div>
              <table id="user_table">
                <tr>
                  <th>회원아이디</th>
                  <th>이름</th>
                  <th>닉네임</th>
                  <th>휴대폰</th>
                  <th>이메일</th>
                  <th>등급</th>
                  <th>회원가입일</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.uid}</td>
                        <td>${user.name}</td>
                        <td>${user.nick}</td>
                        <td>${user.hp }</td>
                        <td>${user.email }</td>
                        <td>${user.role }</td>
                        <td>${user.regDate }</td>
                    </tr>
                </c:forEach>
              </table>
            </div>
          </div>
        </div>
	</main>
	<jsp:include page="/layout/adminfooter.jsp" />
</body>
</html>