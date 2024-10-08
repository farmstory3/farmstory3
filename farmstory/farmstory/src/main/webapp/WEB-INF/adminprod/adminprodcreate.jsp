<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/farmstory/css/adminprodcreate.css">
<body>
<jsp:include page="/layout/adminheader.jsp" />
<main>
	<jsp:include page="/layout/adminsidebar.jsp" />
	<div id="section2_main">
          <div id="section2_title">상품등록</div>
          <div id="article_wrapper">
            <form action="/farmstory/admin/prodcreate.do" id="article1" method="post" enctype="multipart/form-data">
              <div>
              <table id="prod_table">
                <tr id="prod_name">
                  <td>상품명</td>
                  <td><input type="text" name="prod_name"></td>
                </tr>
                <tr id="prod_category">
                  <td>종류</td>
                  <td>
                    <select name="type">
                      <option value="">종류</option>
                      <option value="과일">과일</option>
                      <option value="야채">야채</option>
                      <option value="신선야채">신선야채</option>
                    </select>
                  </td>
                </tr>
                <tr id="prod_price">
                  <td>가격</td>
                  <td><input type="text" name="price"></td>
                </tr>
                <tr id="prod_point">
                  <td>포인트</td>
                  <td><input type="text" name="point">포인트는 가격의 1%</td>
                </tr>
                <tr id="prod_discount">
                  <td>할인</td>
                  <td>
                    <select name="discount">
                      <option value="5">5%</option>
                      <option value="10">10%</option>
                    </select>
                  </td>
                </tr>
                <tr id="prod_delivery">
                  <td>배송비</td>
                  <td>
                    <input type="radio" name="deliveryfee" value="2000">2,000원
                    <input type="radio" name="deliveryfee" value="3000">3,000원
                    <input type="radio" name="deliveryfee" value="5000">5,000원
                    <input type="radio" name="deliveryfee" value="0">무료
                  </td>
                </tr>
                <tr id="prod_stock">
                  <td>재고</td>
                  <td><input type="text" name="stock"></td>
                </tr>
                <tr id="prod_image">
                  <td>상품이미지</td>
                  <td>
                    <a class="img_describe">상품목록 이미지(약 120 X 120)</a>
                    <div>
                      <input type="file" name="file_list"/>
                    </div>
                    <a class="img_describe">기본정보 이미지(약 240 X 240)</a>
                    <div>
                      <input type="file" name="file_basic"/>
                    </div>
                    <a class="img_describe">상품설명 이미지(약 120 X 120)</a>
                    <div>
                      <input type="file" name="file_description"/>
                    </div>
                  </td>
                </tr>
                <tr id="prod_etc">
                  <td>기타</td>
                  <td><textarea name="etc"></textarea></td>
                </tr>
              </table>
              </div>
	          <div id="prod_heading">
	              <a href="#" id="prod_del">취소</a>
	              <button type="submit" id="prod_reg">상품등록</a>
	          </div>
            </form>
          </div>
        </div>
</main>
<jsp:include page="/layout/adminfooter.jsp" />

</body>
</html>