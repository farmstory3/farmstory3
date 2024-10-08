<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ì¥ë³´ê¸°</title>
 
<script>

	window.onload = function() {
		
		
		const total = document.getElementsByClassName('total')[0];
		const stock = document.getElementsByClassName('stock')[0];
		const price = document.getElementsByClassName('price')[0];
		const del = document.getElementsByClassName('frame18-text48')[0];
		const realdel = parseInt(del.innerText,10);
		
		del.innerHTML = (parseInt(del.innerText,10))+'원';
		
		price.innerHTML = (parseInt(price.innerText,10))+'원';
		if(parseInt(price.innerText,10) <= 30000){
			total.innerHTML = (parseInt(price.innerText,10)+parseInt(del.innerText,10))+'원';
			del.innerHTML = realdel + '원';
		} else{
			total.innerHTML = (parseInt(price.innerText,10))+'원';
			del.innerHTML = 0 +'원';
		}
		
		
		
		stock.oninput = function() {
	
			const t_value =(parseInt(price.innerText,10));
			const s_value = stock.value;
				
			if(t_value*stock.value < 30000){
				total.innerHTML = (t_value*stock.value)+parseInt(del.innerText,10)+'원';
				del.innerHTML = realdel + '원';
				
			}else{
				total.innerHTML = (t_value*stock.value)+'원';
				del.innerHTML = 0 +'원';
			}
			
		}
	}

</script>

    </head>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/view.css">
<link rel="stylesheet" href="../css/footer.css">

<body>
	<jsp:include page="/layout/_header.jsp" />
<div class="header-bottom-img">
		<div class="header-bottom-comm">
			<img src="/farmstory/images/sub_top_tit2.png" alt="bottom-img">  <!-- 수정 -->
		</div>
	</div>
</div>
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
            
            <div class="main-gubun-box">
                <div class="frame18-article">
                    <span class="frame18-text08"><span>기본정보</span></span>
                    <div class="frame18-container1">
                      <img class="frame18-marketitemthumbjpg" src=${product.prod_file[0].path}${product.prod_file[0].filename} />
                      <div class="frame18-table">
                        <div class="frame18-body">
                          <div class="frame18-row2">
                            <span class="frame18-text37"><span>상품명</span></span>
                            <span class="frame18-text39"><span>${product.prod_name}</span></span>
                          </div>
                          <div class="frame18-row3">
                            <span class="frame18-text41"><span>상품코드</span></span>
                            <span class="frame18-text43"><span>${product.prod_idx}</span></span>
                          </div>
                          <div class="frame18-row4">
                            <span class="frame18-text45"><span>배송비</span></span>
                            <div class="frame18-data4">
                              <span class="frame18-text47">
                                <span class="frame18-text48">${product.deliveryFee}</span>
                                <span>3만원 이상 무료배송</span>
                              </span>
                            </div>
                          </div>
                          <div class="frame18-row5">
                            <span class="frame18-text50"><span>판매가격</span></span>
                            <span class="frame18-text52"><span class="price">${product.price}</span></span>
                          </div>
                          <div class="frame18-row6">
                            <span class="frame18-text54"><span>구매수량</span></span>
                            <div class="frame18-data-input">                     
                               <input type="number" class="stock" min="0" value="1"/> 
                            </div>
                          </div>
                          <div class="frame18-row7">
                            <span class="frame18-text57"><span>합계</span></span>
                            <span class="frame18-text59"><span class="total">${product.price}</span></span>
                          </div>
                        </div>
                      </div>
                      <a href="/farmstory/market/cart.do" class="frame18-link5">
                        <span class="frame18-text61"><span>장바구니</span></span>
                      </a>
                      <div class="frame18-link6">
                        <span class="frame18-text63"><span>바로구매</span></span>
                      </div>
                    </div>
                  </div>
                </div>
			
                    <span class="frame18-text10"><span>상품설명</span></span>
                    
                   <img src=${product.prod_file[1].path}${product.prod_file[1].filename} class="frame18-marketdetailsamplejpg">
                    <span class="frame18-text12"><span>배송정보</span></span>
                    <span class="frame18-text14">
                      <span>
                         입금하신 이후 택배송장번호는 SMS(문자서비스)를 통해 고객님께 안내해드립니다.
                      </span>
                    </span>
                    <span class="frame18-text16">êµí/ë°í</span>
                    <div class="frame18-table-body">
                      <div class="frame18-row">
                        <div class="frame18-data">
                          <span class="frame18-text18">
                             <span>교환 반품이 가능한 경우</span>
                          </span>
                        </div>
                        <div class="frame18-data1">
                          <div class="frame18-list2">
                            <span class="frame18-text20">
                              <span>팜스토리 상품에 하자가 있거나 불량인 경우</span>
                              <br />
                              <span>채소, 과일, 양곡등의 식품은 만1일 이내</span>
                              <br />
                              <span>
                                기타 상품은 수령일로부터 영업일 기준 일주일 이내
                              </span>
                              <br />
                              <span>
                                받으신 상품이 표시사항과 다른 경우에는 받으신 날로부터
                                일주일 이내
                              </span>
                            </span>
                          </div>
                        </div>
                      </div>
                      <div class="frame18-row1">
                        <div class="frame18-data2">
                          <span class="frame18-text28">
                             <span>교환 반품이 불가능한 경우</span>
                          </span>
                        </div>
                        <div class="frame18-data3">
                          <div class="frame18-list3">
                            <span class="frame18-text30">
                              <span>
                                신선 식품의 경우 단순히 마음에 들지 않는 경우
                              </span>
                              <br />
                              <span>
                                단순 변심으로 상품이 가치가 훼손돼서 판매가 어려운
                                경우
                              </span>
                            </span>
                          </div>
                        </div>
                      </div>
                    </div>
                        <span class="frame18-text34"/>
                     </div>
                     </div>
                  </div>
                 

   <jsp:include page="/layout/_footer.jsp" />	
</body>
</html>