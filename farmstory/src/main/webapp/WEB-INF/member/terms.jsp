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
            <div class="header-logo">
                <div class="logo-link-box">
                    <div class="logo-link">
                        <div>Home</div>
                        <div>|</div>
                        <div>로그인</div>
                        <div>|</div>
                        <div>회원가입</div>
                        <div>|</div>
                        <div>고객센터</div>
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
                <div class="menu-1 menu"></div>
            </div>
            <div>
                <div class="menu-gubun"></div>
                <div class="menu-2 menu"></div>
            </div>
            <div>
                <div class="menu-gubun"></div>
                <div class="menu-3 menu"></div>
            </div>
            <div>
                <div class="menu-gubun"></div>
                <div class="menu-4 menu"></div>
            </div>
            <div>
                <div class="menu-gubun"></div>
                <div class="menu-5 menu"></div>
            </div>
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
                    <a href="/farmstory/member/register.do" class="btnNext">다음</a>
                </div>
            </section>
        </div>
        
    </div>
  <jsp:include page="/layout/_footer.jsp" />	
</body>
</html>