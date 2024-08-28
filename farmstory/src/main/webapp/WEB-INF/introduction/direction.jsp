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
<jsp:include page="/layout/_header.jsp" />
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
        <div class="main-direct-box1">
            <div class="farmstory-addr">팜스토리</div>
            <div class="farmstory-addr1">주소: 경기도 이천시 잘한다구 신난다동 123</div>
            <div class="farmstory-hp">전화: 01-234-5678</div>
        </div>
        <div class="main-direct-box2">
            <div class="farmstory-addrinfo">찾아오시는길</div>
        </div>
        <div class="main-direct-box2"></div>


        </div>
    </div>
    
</div>
<jsp:include page="/layout/_footer.jsp" />	
</body>
</html>