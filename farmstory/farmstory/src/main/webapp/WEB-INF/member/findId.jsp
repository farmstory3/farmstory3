<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 찾기</title>
</head>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/register.css">
<link rel="stylesheet" href="../css/footer.css">
<script src="/farmstory/js/findId.js"></script>

<style>
    .move{
        margin-left: 465px;
    }
</style>

<body>
    <div class="header-wrapper">
        <div class="header-logo-box">
            <div class="header-logo">
                <div class="logo-link-box">
                    <div class="logo-link">
                        <div><a href="/index.html">Home</a></div>
                        <div>|</div>
                        <div><a href="/farmstory/member/login.do">로그인</a></div>
                        <div>|</div>
                        <div><a href="/farmstory/member/register.do">회원가입</a></div>
                        <div>|</div>
                        <div><a href="../community/qna.html">고객센터</a></div>
                    </div>
                </div>
                <div class="logo-add-box">

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
                <a href="../introduction/introduction.html">
                    <div class="menu-1 menu"></div>
                </a>
            </div>
            <div>
                <div class="menu-gubun"></div>
                <a href="../market/list.html">
                    <div class="menu-2 menu"><img src="../images/head_menu_badge.png" alt="badge"></div>
                </a>
            </div>
            <div>
                <div class="menu-gubun"></div>
                <a href="../croptalk/story.html">
                    <div class="menu-3 menu"></div>
                </a>
            </div>
            <div>
                <div class="menu-gubun"></div>
                <a href="../event/info.html">
                    <div class="menu-4 menu"></div>
                </a>
            </div>
            <div>
                <div class="menu-gubun"></div>
                <a href="../community/notice.html">
                    <div class="menu-5 menu"></div>
                </a>
            </div>
        </div>

        </div>
    </div>
    <div class="main-wrapper">

        <div class="main-box">
            <section class="register">
                <form action="/farmstory/member/findId.do" method="POST">
                    <table border="1">
                        <caption>아이디찾기</caption>
                        <tr>
                            <td>E-Mail</td>
                            <td>
                                 <input type="email" name="email" placeholder="이메일 입력"/>
                       			<button type="button" id="btnSendEmail"><img src="../images/chk_auth.gif" alt="인증번호 받기"/></button>
                       			<span class="resultEmail"></span>
                       			<div class="auth">
                           		<input type="text" name="auth" placeholder="인증번호 입력"/>
                           		<button type="button" id="btnAuthEmail"><img src="../images/chk_confirm.gif" alt="확인"/></button>
                                </div>
                            </td>
                        </tr>
                    </table> 
                    <table border="1">
                        <caption class="move">
                            <a href="/farmstory/member/login.do">로그인 |</a>
                            <a href="/farmstory/member/findPass.do">비밀번호찾기</a>
                        </caption>
                    
                    </table> 
                </form>
            </section>
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
</body>
</html>