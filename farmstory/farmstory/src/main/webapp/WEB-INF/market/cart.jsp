<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>장바구니</title>
</head>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/cart.css">
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
                <div class="sidebar-item-1">
                <a href="/matket/view.html">
                    <div class="sidebar-item _01"></div>
                </a>
                <a href="/matket/view.html">
                    <div class="sidebar-item _02 _ov"></div>
                </a>
                </div>
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
                <div class="frame19-article">
                    <span class="frame19-text008">
                      <span>장바구니 전체(10)</span>
                    </span>
                    <div class="frame19-table">
                      <div class="frame19-header-row">
                        <div class="frame19-cell">
                           <input type="checkbox" class="frame19-input"/>
                        </div>
                        <div class="frame19-cell1">
                          <span class="frame19-text010"><span>이미지</span></span>
                        </div>
                        <div class="frame19-cell2">
                          <span class="frame19-text012"><span>종류</span></span>
                        </div>
                        <div class="frame19-cell3">
                          <span class="frame19-text014"><span>상품명</span></span>
                        </div>
                        <div class="frame19-cell4">
                          <span class="frame19-text016"><span>수량</span></span>
                        </div>
                        <div class="frame19-cell5">
                          <span class="frame19-text018"><span>할인</span></span>
                        </div>
                        <div class="frame19-cell6">
                          <span class="frame19-text020"><span>포인트</span></span>
                        </div>
                        <div class="frame19-cell7">
                          <span class="frame19-text022"><span>가격</span></span>
                        </div>
                        <div class="frame19-cell8">
                          <span class="frame19-text024"><span>소계</span></span>
                        </div>
                      </div>
                      <div class="frame19-body">
                        <div class="frame19-row">
                          <span class="frame19-text026">
                            <span>장바구니에 상품이 없습니다.</span>
                          </span>
                        </div>
                        <div class="frame19-row01">
                          <input type="checkbox" class="frame19-data-input"/>
                          <div class="frame19-data-linkmarketitem1jpg"></div>
                          <span class="frame19-text028"><span>과일</span></span>
                          <span class="frame19-text030"><span>사과 500g</span></span>
                          <span class="frame19-text032">1</span>
                          <span class="frame19-text033"><span>10%</span></span>
                          <span class="frame19-text035"><span>40P</span></span>
                          <span class="frame19-text037"><span>4,000</span></span>
                          <div class="frame19-data">
                            <span class="frame19-text039">
                              <span class="frame19-text040">3,600원</span>
                            </span>
                          </div>
                        </div>
                      </div>
                    </div>
                    <button type="submit" class="frame19-input1">선택삭제</button>
                    <div class="frame19-border">
                      <div class="frame19-table1">
                        <span class="frame19-text070"><span>전체합계</span></span>
                        <div class="frame19-body1">
                          <div class="frame19-row04">
                            <span class="frame19-text072"><span>상품수</span></span>
                            <span class="frame19-text074">1</span>
                          </div>
                          <div class="frame19-row05">
                            <span class="frame19-text075"><span>상품금액</span></span>
                            <span class="frame19-text077"><span>27,000</span></span>
                          </div>
                          <div class="frame19-row06">
                            <span class="frame19-text079"><span>할인금액</span></span>
                            <span class="frame19-text081"><span>5,0000원</span></span>
                          </div>
                          <div class="frame19-row07">
                            <span class="frame19-text083"><span>배송비</span></span>
                            <span class="frame19-text085"><span>5,0000원</span></span>
                          </div>
                          <div class="frame19-row08">
                            <span class="frame19-text087"><span>포인트</span></span>
                            <span class="frame19-text089"><span>4,000원</span></span>
                          </div>
                          <div class="frame19-row09">
                            <span class="frame19-text091">
                              <span>전체주문금액</span>
                            </span>
                            <span class="frame19-text093"><span>22,000</span></span>
                          </div>
                        </div>
                      </div>
                      <button type="submit" class="frame19-input2">주문하기</button>
                    </div>
                  </div>
                </div>
            </div>
          </div>
    </div>
    <jsp:include page="/layout/_footer.jsp" />	
</body>
</html>