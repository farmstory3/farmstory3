<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<link rel="stylesheet" href="/farmstory/css/header.css">
<link rel="stylesheet" href="/farmstory/css/register.css">
<link rel="stylesheet" href="/farmstory/css/footer.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/farmstory/js/postcode.js"></script>
<script src="/farmstory/js/validation.js"></script>


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
                        <section class="register">
                <form action="/farmstory/member/register.do" method="POST">
                    <table border="1">
                        <caption>사이트 이용정보 입력</caption>
                        <tr>
                            <td>아이디</td>
                            <td>
                                <input type="text" name="uid" placeholder="아이디 입력"/>
                                <button  type="button" id="btnCheckUid"><img src="/farmstory/images/chk_id.gif" alt=""></button>
                                <span class="resultId"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td>
                                <input type="password" name="pass1" placeholder="비밀번호 입력"/>                            
                            </td>
                        </tr>
                        <tr>
                            <td>비밀번호 확인</td>
                            <td>
                                <input type="password" name="pass2" placeholder="비밀번호 확인 입력"/>
                                <span class="resultPass"></span>
                            </td>
                        </tr>
                    </table>
                    <table border="1">
                        <caption>개인정보 입력</caption>
                        <tr>
                            <td>이름</td>
                            <td>
                                <input type="text" name="name" placeholder="이름 입력"/>  
                                <span class="resultName"></span>                          
                            </td>
                        </tr>
                        <tr>
                            <td>별명</td>
                            <td>
                                <p>공백없이 한글, 영문, 숫자만 입력가능</p>
                                <input type="text" name="nick" placeholder="별명 입력"/>
                                <span class="resultNick"></span>                            
                            </td>
                        </tr>
                        <tr>
                            <td>E-Mail</td>
                            <td>
                                 <input type="email" name="email" placeholder="이메일 입력"/>
                       			<button type="button" id="btnSendEmail"><img src="/farmstory/images/chk_auth.gif" alt="인증번호 받기"/></button>
                       			<span class="resultEmail"></span>
                       			<div class="auth">
                           		<input type="text" name="auth" placeholder="인증번호 입력"/>
                           		<button type="button" id="btnAuthEmail"><img src="/farmstory/images/chk_confirm.gif" alt="확인"/></button>
                       </div>
                            </td>
                        </tr>
                        <tr>
                            <td>휴대폰</td>
                            <td>
                                <input type="text" name="hp" placeholder="- 포함 13자리 입력" minlength="13" maxlength="13" />
                            	 <span class="resultHp"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>주소</td>
                            <td>
                                <div>
                                    <input type="text" name="zip" id="zip" placeholder="우편번호" readonly/>                                
                                    <button type="button" class="btnZip" onclick="postcode()"><img src="/farmstory/images/chk_post.gif" alt=""></button>
                                </div>                            
                                <div>
                                    <input type="text" name="addr1" id="addr1" placeholder="주소를 검색하세요." readonly/>
                                </div>
                                <div>
                                    <input type="text" name="addr2" id="addr2" placeholder="상세주소를 입력하세요."/>
                                </div>
                            </td>
                        </tr>
                    </table>
    
                    <div>
                        <a href="/farmstory/member/login.do" class="btnCancel">취소</a>
                        <input type="submit"   class="btnSubmit" value="회원가입"/>
                    </div>    
                </form>
            </section>
        </div>
        
    </div>
    <jsp:include page="/layout/_footer.jsp" />	
</body>
</html>