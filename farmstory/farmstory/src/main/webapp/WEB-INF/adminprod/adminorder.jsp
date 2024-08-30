<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
    	
	    function selectAll(selectAllCheckbox) {
	        // order_table 테이블에서 모든 체크박스를 가져옴
	        const checkboxes = document.querySelectorAll('#order_table input[type="checkbox"][name="selectedProducts"]');
	        
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
            window.location.href = '/farmstory/admin/order.do'; // 삭제 후 다른 페이지로 이동하고 싶다면 사용
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
<link rel="stylesheet" href="/farmstory/css/adminorder.css">
<body>
	<jsp:include page="/layout/adminheader.jsp" />
	<main>
		<jsp:include page="/layout/adminsidebar.jsp" />
		<div id="section2_main">
          <div id="section2_title">주문목록</div>
          <div id="article_wrapper">
            <div id="article1">
              <table id="order_table">
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
                	<td><input name="selectedProducts" type="checkbox" value="${order.order_idx}"></td>
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
              <a href="#" onclick="submitSelectedProducts(event)" id="prod_del">선택삭제</a>
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
            const url = "/farmstory/admin/deleteOrder.do?"+queryString;
            window.location.href = url;
        } else {
            alert('Please select at least one product.');
        }
    }
</script>
</body>

</html>