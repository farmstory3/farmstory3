<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>인사말</title>
</head>
<link rel="stylesheet" href="/farmstory/css/header.css">
<link rel="stylesheet" href="/farmstory/css/introduction.css">
<link rel="stylesheet" href="/farmstory/css/footer.css">
<body>
<jsp:include page="/layout/_header.jsp" />
<div class="main-wrapper">
    <div class="sidebar-box">
        <div class="sidebar-logo-box">
            <div class="sidebar-logo"></div>
        </div>
        <div class="sidebar-bg-box">
            <a href="/farmstory/introduction/hello.do">
                <div class="sidebar-item _01 _ov"></div>
            </a>
            <a href="/farmstory/introduction/direction.do">
                <div class="sidebar-item _02"></div>
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
                <div class="nav-tit-3">인사말</div>
            </div>
        </div>
        <div class="main-gubun-box">
        </div>
        <div class="main-intro-box1"></div>
        <div class="main-intro-box2">
            <div class="farmstory-intro1">항상 저희 팜스토리를 성원해주시고 관심을 가져주시는 모든 분들께 감사의 인사를 드리며</div>
            <div class="farmstory-intro2">가정에 건강과 행복이 가득하시길 기원합니다.</div>
        </div>
        <div class="main-intro-box3">
            <div class="farmstory-intro3">팜스토리는 신선하고 안전한 먹거리로 건강한 삶 만들기에 기여합니다.</div>
            <div class="farmstory-intro4">보다 좋은 농산물을 공급하기 위해 화학비료를 쓰지 않는 건강한 흙에서 유기농업으로 정성을 다해 지은 농사를 통해 믿고 먹을 수 있는 먹거리 제</div>
            <div class="farmstory-intro5">공에 앞장서겠습니다.</div>
        </div>
        <div class="main-intro-box4">
            <div class="farmstory-intro6">친환경 농장</div>
            <div class="farmstory-intro7">팜스토리는 경기도 이천에 위치한 10만평 규모의 유기농 재배단지입니다.</div>
        </div>
        <div class="main-intro-box5">
            <div class="farmstory-intro8">친환경 캠페인</div>
            <div class="farmstory-intro9">팜스토리는 2차 포장재 사용을 줄임으로써 친환경적인 포장과, 친환경적인 소비문화 정착을 위해 노력합니다.</div>
        </div>


        </div>
    </div>
    
</div>
<jsp:include page="/layout/_footer.jsp" />	
</html>