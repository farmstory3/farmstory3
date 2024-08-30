<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>cart</title>
</head>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/cart.css">
<link rel="stylesheet" href="../css/footer.css">
<body>
<jsp:include page="/layout/_header.jsp" />

    <div class="main-wrapper">
        <div class="sidebar-box">
            <div class="sidebar-logo-box">
                <div class="sidebar-logo"></div>
            </div>
            <div class="sidebar-bg-box">
                <div class="sidebar-item-1"></div>
                <div class="sidebar-item-2"></div>
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
                    <div class="nav-tit-2">장보기</div>
                    <div class="nav-latest-icon">></div>
                    <div class="nav-tit-3">장보기</div>
                </div>
            </div>
         
         <div class="main-gubun-box"></div>
            	
         <div class="main-cart-box">
              <form action="/farmstory/market/deletecart.do" method="post" class="main-list-box">
                <div class="list-title-box">주문상품 전체</div>
                <div class="list-item-head-box">
                  <div class="discount-title"><input type="checkbox"></div>
                  <div class="img-title">이미지</div>
                  <div class="type-title">종류</div>
                  <div class="name-title">상품명</div>
                  <div class="quantity-title">수량</div>
                  <div class="discount-title">할인</div>
                  <div class="point-title">포인트</div>
                  <div class="price-title">가격</div>
                  <div class="sum-title">소계</div>
                </div>
                <c:forEach var="cart" items="${cart_items}">
                <div class="list-item-body-box">
                  <div class="body-box">
                  	<input class="discount-body-box" type="checkbox" name="check" value="${cart.cart_item_idx}">
                  </div> 
                  <div class="img-body-box body-box">
                    <img class="img-body" src="${cart.path}${cart.fileName}">
                  </div>
                  <div class="type-body-box body-box">
                    <div class="type-body">${cart.type}</div>
                  </div>
                  <div class="title-body-box body-box">
                    <div class="name-title">${cart.prod_name}</div>
                  </div>
                  <div class="quantity-body-box body-box">
                    <div class="name-quantity">${cart.quantity}</div>
                  </div>
                  <div class="discount-body-box body-box">
                    <div class="name-discount">${cart.discount}%</div>
                  </div>
                  <div class="point-body-box body-box">
                    <div class="name-point">${cart.point}p</div>
                  </div>
                  <div class="pricet-body-box body-box">
                    <div class="name-price">${cart.price*cart.quantity}원</div>
                  </div>
                  <div class="sum-body-box body-box">
                    <div class="name-sum">${cart.sum}원</div>
                  </div>
                
                </div>
                </c:forEach>
                <div>
                	<button type="submit">선택삭제</button>
                </div>
              </form>
             
              <div class="main-second-box">
                <div class="main-client-box">
                  <div class="main-info-box">
                    <div class="info-title-box">
                      <div class="info-title">주문 정보 입력</div>
                    </div>
                    <div class="info-input-box-header input-box" >
                      <div class="title-box">
                        주문자
                      </div>
                      <div class="inp-box">
                        <input class="inp" type="text">
                      </div>
                    </div>
                    <div class="info-input-box input-box" >
                      <div class="title-box">
                        휴대폰
                      </div>
                      <div class="inp-box">
                        <input class="inp" type="text">
                      </div>
                    </div>
                    <div class="info-input-box input-box" >
                      <div class="point-title-box">
                        포인트사용
                      </div>
                      <div class="inp-box point-box">
                        <div class="point">
                          <input class="inp" type="text">
                          <input type="button" value="사용하기">
                        </div>
                        <div class="text-box">
                          <div class="text">
                            사용가능 : 2,000
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="info-input-box input-box" >
                      <div class="title-box">
                        받는분
                      </div>
                      <div class="inp-box">
                        <input class="inp" type="text">
                      </div>
                    </div>
                    <div class="info-input-box input-box" >
                      <div class="title-box">
                        연락처
                      </div>
                      <div class="inp-box">
                        <input class="inp" type="text">
                      </div>
                    </div>
                    <div class="info-input-box input-box" >
                      <div class="delivery-title-box">
                        배송주소
                      </div>
                      <div class="inp-box addr-box">
                        <div class="text-box">
                          <input class="inp" type="text">
                          <input type="button" value="우편번호검색">
                        </div>
                        <div class="text-box">
                          <input type="text" placeholder="기본주소 검색">
                        </div>
                        <div class="text-box">
                          <input type="text" placeholder="상세주소 입력">
                        </div>
                      </div>
                    </div>
                    <div class="info-input-box input-box" >
                      <div class="title-box">
                        결제방법
                      </div>
                      <div class="inp-box">
                        <input class="inp" type="text">
                      </div>
                    </div>
                    <div class="info-input-box input-box" >
                      <div class="title-box">
                        기타
                      </div>
                      <div class="inp-box">
                        <input class="inp" type="text">
                      </div>
                    </div>
                  </div>
                </div>
                <form class="main-order-box">
                  <hr>
                  <div class="order-title-box">
                    <div class="order-title">최종 결제 정보</div>
                    <div class="o-quantity-box o-box">
                      <div class="order-quantity">수량</div>
                      <div class="order-b-quantity">${cart_items_sum.quantity}</div>
                    </div>
                    <div class="o-quantity-box o-box">
                      <div class="order-quantity">상품금액</div>
                      <div class="order-b-quantity">${cart_items_sum.price}원</div>
                    </div>
                    <div class="o-quantity-box o-box">
                      <div class="order-quantity">할인금액</div>
                      <div class="order-b-quantity">5%</div>
                    </div>
                    <div class="o-quantity-box o-box">
                      <div class="order-quantity">포인트사용</div>
                      <div class="order-b-quantity">${cart_items_sum.point}p</div>
                    </div>
                    <div class="o-quantity-box o-box">
                      <div class="order-quantity">배송비</div>
                      <div class="order-b-quantity">0원</div>
                    </div>
                    <div class="o-quantity-box o-box">
                      <div class="order-quantity">포인트적립</div>
                      <div class="order-b-quantity">${cart_items_sum.savePoint}p</div>
                    </div>
                    <div class="o-quantity-box o-box">
                      <div class="order-quantity">전체주문금액</div>
                      <div class="order-b-quantity">${cart_items_sum.sum-cart_items_sum.point-Math.floor(cart_items_sum.sum*0.05)}원</div>
                    </div>
                  </div>
                  <br>
                  <hr>
                  <button class="btn-box">결제하기</button>
                </form>
              </div>
              </div>
            </div>
            </div>
    <jsp:include page="/layout/_footer.jsp" />	
</body>
</html>