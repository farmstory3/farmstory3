<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/farmstory/css/adminorder.css">
<body>
	<jsp:include page="/layout/adminheader.jsp" />
	<main>
		<jsp:include page="/layout/adminsidebar.jsp" />
		<div id="section2_main">
          <div id="section2_title">주문목록</div>
          <div id="article_wrapper">
            <div id="article1">
              <table id="prod_table">
                <tr>
                  <th><input type="checkbox"></th>
                  <th>주문번호</th>
                  <th>상품명</th>
                  <th>판매가격</th>
                  <th>수량</th>
                  <th>배송비</th>
                  <th>합계</th>
                  <th>주문자</th>
                  <th>주문일</th>
                  <th>확인</th>
                </tr>
                <c:forEach var="order" items="${orders}">
                <tr>
                	<td><input type="checkbox"/></td>
                	<td>${order.order_idx }</td>
                	<td>${order.prod_name }</td>
                	<td>${order.price }</td>
                	<td>${order.quantity }</td>
                	<td>${order.deliveryFee }</td>
                	<td>${order.total_price }</td>
                	<td>${order.uid }</td>
                	<td>${order.order_rdate }</td>
                	<td><a href="#">[상세확인]</a></td>
                </tr>
   				</c:forEach>
              </table>
            </div>
            <div id="prod_heading">
              <a href="#" id="prod_del">선택삭제</a>
            </div>
            <div id="list_num">
              <a><</a>
              <a href="#">[1]</a>
              <a href="#">[2]</a>
              <a href="#">[3]</a>
              <a href="#">[4]</a>
              <a href="#">[5]</a>
              <a>></a>
            </div>
          </div>
        </div>
	</main>
	<jsp:include page="/layout/adminfooter.jsp" />
</body>
</html>