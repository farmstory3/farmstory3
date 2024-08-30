<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이용약관</title>
</head>
<link rel="stylesheet" href="/farmstory/css/header.css">
<link rel="stylesheet" href="/farmstory/css/terms.css">
<link rel="stylesheet" href="/farmstory/css/footer.css">
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<body>
    <div class="header-wrapper">
        <div class="header-logo-box">
            <div class="header-logo" onclick="location.href='/farmstory'">
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
							<a href="/farmstory/article/list.do?group=community&cate=qna">고객센터</a>
						</div>
                    </div>
                </div>
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
            <a href="/farmstory/market/list.do" id="menu2">
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

        </div>
    <div class="main-wrapper">
        <div class="main-box">
            <section class="terms">
                <table>
                    <caption>사이트 이용약관</caption>
                    <tr>
                        <td>
                            <textarea readonly>${terms.terms}</textarea>
                            <p>
                                <label><input type="checkbox" name="chk1"/>동의합니다.</label>
                            </p>
                        </td>
                    </tr>
                </table>
                <table>
                    <caption>개인정보 취급방침</caption>
                    <tr>
                        <td>
                            <textarea readonly>${terms.privacy}</textarea>
                            <p>
                                <label><input type="checkbox" name="chk2"/>동의합니다.</label>
                            </p>
                        </td>
                    </tr>
                </table>
                <div>
                    <a href="/farmstory/member/login.do" class="btnCancel">취소</a>
                   <a href="#" class="btnNext" id="btnNext" onclick="if(checkAgree()){ window.location.href='/farmstory/member/register.do'; }">다음</a>
                </div>
            </section>
        </div>
	 </div>
	 <script>
	  	function checkAgree() {
	 		var chk1 = document.getElementsByName('chk1')[0].checked;
	 		var chk2 = document.getElementsByName('chk2')[0].checked;

	 		
	 		if (!chk1){
	 			alert("사이트 이용약관에 동의하셔야 합니다.");
	 			return false;
	 		}
	 		
	 		if (!chk2){
	 			alert("개인정보 취급방침에 동의하셔야 합니다.");
	 			return false;
	 		}
	 		
	 		return true;
	 	
	 		
	 		
	 		
		}
	 
	 </script>
	 
	 
  <jsp:include page="/layout/_footer.jsp" />	
</body>
</html>