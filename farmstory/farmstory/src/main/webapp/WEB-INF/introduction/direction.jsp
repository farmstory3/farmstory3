<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>찾아오시는길</title>
</head>
<link rel="stylesheet" href="/farmstory/css/header.css">
<link rel="stylesheet" href="/farmstory/css/direction.css">
<link rel="stylesheet" href="/farmstory/css/footer.css">
<body>
<div class="header-wrapper">
    <div class="header-logo-box">
        <div class="header-logo"  onclick="location.href='/farmstory'">
            <div class="logo-link-box">
                <div class="logo-link">
                    <div><a href="/farmstory">Home</a></div>
                    <div>|</div>
                    <div><a href="/farmstory/member/login.do">로그인</a></div>
                    <div>|</div>
                    <div><a href="/farmstory/member/register.do">회원가입</a></div>
                    <div>|</div>
                    <div><a href="/farmstory/community/qna.html">고객센터</a></div>
                </div>
            </div>
            <div class="logo-add-box">

            </div>
        </div>
    </div>
    <div class="header-side-box">
        <div class="menu-1"></div>
        <div class="menu-2"></div>
        <div class="menu-3"></div>
        <div class="menu-4"></div>
        <div class="menu-5"></div>
    </div>
    <div class="header-menu-box">
        <div>
            <div class="menu-gubun"></div>
            <a href="/farmstory/introduction/hello.do">
                <div class="menu-1 menu"></div>
            </a>
        </div>
        <div>
            <div class="menu-gubun"></div>
            <a href="/farmstory/market/list.do">
                <div class="menu-2 menu"><img src="/farmstory/images/head_menu_badge.png" alt="badge"></div>
            </a>
        </div>
        <div>
            <div class="menu-gubun"></div>
            <a href="/farmstory/article/list.do?group=croptalk&cate=story">
                <div class="menu-3 menu"></div>
            </a>
        </div>
        <div>
            <div class="menu-gubun"></div>
            <a href="/farmstory/article/list.do?group=event&cate=info">
                <div class="menu-4 menu"></div>
            </a>
        </div>
        <div>
            <div class="menu-gubun"></div>
            <a href="/farmstory/article/list.do?group=community&cate=notice">
                <div class="menu-5 menu"></div>
            </a>
        </div>
    </div>
	<div class="header-bottom-img">
		<div class="header-bottom-comm">
			<img src="/farmstory/images/sub_top_tit1.png" alt="bottom-img">  <!-- 수정 -->
		</div>
	</div>
</div>
<div class="main-wrapper">
    <div class="sidebar-box">
        <div class="sidebar-logo-box">
            <div class="sidebar-logo"></div>
        </div>
        <div class="sidebar-bg-box">
            <a href="/farmstory/introduction/hello.do">
                <div class="sidebar-item _01"></div>
            </a>
            <a href="/farmstory/introduction/direction.do">
                <div class="sidebar-item _02 _ov"></div>
            </a>
        </div>
        
    </div>
    <div class="sidebar-gubun-box"></div>





    <div class="main-box">
        <div class="main-title-box">
            <div class="main-title"></div>
            <div class="main-nav-box">
                <div class="">
                    <div class=""></div>
                </div>
                <div class="nav-tit-1">Home</div>
                <div class="nav-latest-icon">></div>
                <div class="nav-tit-2">팜스토리소개</div>
                <div class="nav-latest-icon">></div>
                <div class="nav-tit-3">찾아오시는길</div>
                
            </div>
        </div>
        <div class="main-gubun-box">
        </div>
        <div class="main-direct-box1">
            <div class="farmstory-addr">팜스토리</div>
            <div class="farmstory-addr1">주소: 경기도 이천시 잘한다구 신난다동 123</div>
            <div class="farmstory-hp">전화: 01-234-5678</div>
        </div>
        <div class="main-direct-box2">
            <div class="farmstory-addrinfo">찾아오시는길</div>
        
        <div id="map" style="width:100%;height:400px; margin-top: 10px;"></div>
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b6162e21b9454faef40f21e347dcec6e&libraries=services"></script>
				
		</div>
    </div>
    
</div>
<div class="footer-wrapper">
    <div class="footer-gubun-box"></div>
    <div class="footer-main-box">
        <div class="footer-logo-box"></div>
        <div class="footer-info-box">
            <div class="footer-info-detail">
                <div>(주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제 2013-팜스토리구-123호 / 벤처기업확인 서울지방중소기업청 제 012345678-9-01234호</div>
                <div>등록번호 팜스토리01234 (2013.04.01) / 발행인 : 홍길동</div>
                <div>대표 : 홍길동 / 이메일 : email@mail.mail / 전화 : 01) 234-5678 / 경기도 성남시 잘한다구 신난다동 345</div>
                <div class="footer-info-copywriter">Copyright(C)홍길동 All rights reserved.</div>
            </div>
            
        </div>
    </div>
</div>
<script>
    document.querySelectorAll(".sidebar-item").forEach(function (item) {
        item.addEventListener("click", function () {
            document
                .querySelectorAll(".sidebar-item")
                .forEach(function (i) {
                    i.classList.remove("_ov");
                });
            this.classList.add("_ov");
        });
    });
    
    var mapContainer = document.getElementById('map'),
    mapOption = {
        center: new kakao.maps.LatLng(35.1798160, 129.0750223),
        level: 3 // 지도의 확대 레벨
    };  
 
var map = new kakao.maps.Map(mapContainer, mapOption); 

var geocoder = new kakao.maps.services.Geocoder();

geocoder.addressSearch('부산 연제구 중앙대로 1001', function(result, status) {

     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

       
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:250px;text-align:center;padding:6px 0;">부산광역시 연제구 중앙대로 1001</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>
</body>
</html>