<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
</head>
<link rel="stylesheet" href="/farmstory/css/adminheader.css">
<link rel="stylesheet" href="/farmstory/css/login.css">
<link rel="stylesheet" href="/farmstory/css/adminfooter.css">
<script>
	const success= ${success};
	
	if(success == 100){
		alert('로그인에 실패했습니다. \n다시 한번 아이디, 비밀번호를 확인 하시기 바랍니다.');
	} else if(success == 101){
		alert('정상적으로 로그아웃 되었습니다.');
	} else if(success == 102){
		alert('먼저 로그인을 하셔야 합니다.');
	} else if(success == 103){
		alert('관리자 계정이 아닙니다.');
	}
</script>
<body>
	<div class="header_wrapper">
      <header>
        <a id="logo">
          <img src="/farmstory/images/admin_logo.jpg" alt="admin_logo"/>
        </a>
        <div class="home">
          <a href="/farmstory">HOME</a>
        </div>
      </header>
      </div>
	<main>
		    <div class="main-wrapper">
        <div class="main-box">
            <section class="login">
                <form action="/farmstory/admin/login.do" method="POST">
                    <table border="0">
                        <tr>
                            <td><img src="/farmstory/images/login_ico_id.png" alt="아이디"></td>
                            <td><input type="text" name="uid" placeholder="아이디 입력"></td>
                        </tr>
                        <tr>
                            <td><img src="/farmstory/images/login_ico_pw.png" alt="비밀번호"></td>
                            <td><input type="password" name="pass" placeholder="비밀번호 입력"></td>
                        </tr>
                    </table>
                    <input type="submit" value="로그인" class="btnLogin" style="cursor: pointer">
                </form>	
                <div>
                    <h3>관리자 로그인 안내</h3>
                    <p>
                        관리자 전용 로그인 페이지입니다.
                    </p>
                    <a href="/farmstory/member/terms.do">회원가입</a>
                </div>
            </section>
        </div>
    </div>
	</main>
	<jsp:include page="/layout/adminfooter.jsp" />
</body>
</html>