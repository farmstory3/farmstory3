<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/farmstory/css/adminsidebar.css">
</head>
<%
    String currentPage = request.getServletPath();
	int lastSlashIndex = currentPage.lastIndexOf("/");
	int lastDotIndex = currentPage.lastIndexOf(".");
	String fileName = currentPage.substring(lastSlashIndex + 1, lastDotIndex);
	System.out.print(fileName);
%>
<body>
	<div id="section1">
          <div id="section1_head">
            <a>주요기능</a>
          </div>
          <div id="section1_menu">
            <ul id="prod_manage">
              상품관리
              <div>
                <li id="prod_list" <%= "adminproduct".equals(fileName) ? "class='active'" : "" %> >L 
		            <a href="/farmstory/admin/product.do">상품목록</a>
		        </li>
		        <li id="prod_register" <%= "adminprodcreate".equals(fileName) ? "class='active'" : "" %> >L 
		            <a href="/farmstory/admin/prodcreateview.do">상품등록</a>
		        </li>
              </div>
            </ul>
            <ul id="order_manage">
              주문관리
              <li id="order_list" <%= "adminorder".equals(fileName) ? "class='active'" : "" %> >L 
                <a href="/farmstory/admin/order.do">주문목록</a>
              </li>
            </ul>
            <ul id="user_manage">
              회원관리
              <li id="user_list" <%= "adminMember".equals(fileName) ? "class='active'" : "" %> >L 
                <a href="/farmstory/admin/member.do">회원목록</a>
              </li>
            </ul>
          </div>
        </div>
</body>
</html>