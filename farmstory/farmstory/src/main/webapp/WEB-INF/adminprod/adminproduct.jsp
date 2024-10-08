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
<script type="text/javascript">
    	
	    function selectAll(selectAllCheckbox) {
	        // prod_table 테이블에서 모든 체크박스를 가져옴
	        const checkboxes = document.querySelectorAll('#prod_table input[type="checkbox"][name="selectedProducts"]');
	        
	        checkboxes.forEach((checkbox) => {
	            checkbox.checked = selectAllCheckbox.checked;
	        });
	    }
    
</script>
<%
		Integer resultObj = (Integer) request.getAttribute("r");
		int result = (resultObj != null) ? resultObj : -1;
		if(result == 1) {
%>
        <script>
            alert('삭제 성공');
            window.location.href = '/farmstory/admin/product.do'; // 삭제 후 다른 페이지로 이동하고 싶다면 사용
        </script>
<%
    } else if(result == 2) {
%>
        <script>
            alert('삭제상품에 처리되지 않은 주문이 있습니다.');
        </script>
<%
    } else if(result == 0 ) {
%>	
	<script>
		alert('해당 상품이 존재하지 않습니다.')
	</script>
<%
    }
%>
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
                	<td><img id="sample_img" src=${productList.path}${productList.url} alt="sample">
                	</td>
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
              <a href="/farmstory/admin/prodcreateview.do" id="prod_reg">상품등록</a>
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