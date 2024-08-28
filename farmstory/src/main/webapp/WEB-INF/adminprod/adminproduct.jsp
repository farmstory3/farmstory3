<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/farmstory/css/adminproduct.css">
</head>
<body>
	
	<jsp:include page="/layout/adminheader.jsp" />
	<main>
		<jsp:include page="/layout/adminsidebar.jsp" />
		<div id="section2_main">
          <div id="section2_title">상품목록</div>
          <div id="article_wrapper">
            <div id="article1">
              <table id="prod_table">
                <tr>
                  <th><input type="checkbox"></th>
                  <th>사진</th>
                  <th>상품번호</th>
                  <th>상품명</th>
                  <th>구분</th>
                  <th>가격</th>
                  <th>재고</th>
                  <th>등록일</th>
                </tr>
                
                <c:forEach var="productList" items="${productLists }">
                <tr>
                	<td><input name="selectedProducts" type="checkbox" value="${productList.prod_idx}"></td>
                	<td><img id="sample_img" src=${productList.path}${productList.url} alt="sample"></td>
                	<td>${productList.prod_idx }</td>
                	<td>${productList.prod_name }</td>
                	<td>${productList.type }</td>
                	<td>${productList.price }</td>
                	<td>${productList.stock }</td>
                	<td>${productList.regDate }</td>
                </tr>
                </c:forEach>
              </table>
            </div>
            <div id="prod_heading">
              <a href="#" onclick="submitSelectedProducts(event)" id="prod_del">선택삭제</a>
              <a href="#" id="prod_reg">상품등록</a>
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
	
<script>
    function submitSelectedProducts(event) {
    	event.preventDefault();
        // 체크된 체크박스 값 수집
        const checkboxes = document.querySelectorAll('input[name="selectedProducts"]:checked');
        const selectedValues = Array.from(checkboxes).map(cb => cb.value);

        if (selectedValues.length > 0) {
            // 쿼리 스트링 생성
            const queryString = selectedValues.map(value => "selectedProducts="+value).join('&');
			console.log("sdfasddfas"+queryString);
            // 원하는 URL로 이동
            const url = "/farmstory/admin/deleteProduct.do?"+queryString;
            window.location.href = url;
        } else {
            alert('Please select at least one product.');
        }
    }
</script>
</body>
</html>