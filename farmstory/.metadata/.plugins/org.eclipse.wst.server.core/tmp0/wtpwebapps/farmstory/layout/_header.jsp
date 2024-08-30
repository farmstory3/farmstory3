<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>농작물이야기</title>
</head>
<link rel="stylesheet" href="/farmstory/css/header.css">
<link rel="stylesheet" href="/farmstory/css/footer.css">

<body>
	<div class="header-wrapper">
		<div class="header-logo-box">
			<div class="header-logo"  onclick="location.href='/farmstory'">
				<div class="logo-link-box">
					<div class="logo-link">
						<div>
							<a href="/farmstory">Home</a>
						</div>
						<div>|</div>
						<div>
							<a href="/farmstory/member/login.do">로그인</a>
						</div>
						<div>|</div>
						<div>
							<a href="/farmstory/register.do">회원가입</a>
						</div>
						<div>|</div>
						<div>
							<a href="/farmstory/community/qna.html">고객센터</a>
						</div>
					</div>
				</div>
				<div class="logo-add-box"></div>
			</div>
		</div>
		<div class="header-gubun-box">
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
				<a href="/farmstory//market/list.do">
					<div class="menu-2 menu">
						<img src="../images/head_menu_badge.png" alt="badge">
					</div>
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
				<img src="/farmstory/images/sub_top_tit_${group}.png" alt="bottom-img5">  <!-- 수정 -->
			</div>
		</div>
	</div>