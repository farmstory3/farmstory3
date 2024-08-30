<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class="footer-wrapper">
		<div class="footer-gubun-box"></div>
		<div class="footer-main-box">
			<div class="footer-logo-box"></div>
			<div class="footer-info-box">
				<div class="footer-info-detail">
					<div>(주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제
						2013-팜스토리구-123호 / 벤처기업확인 서울지방중소기업청 제 012345678-9-01234호</div>
					<div>등록번호 팜스토리01234 (2013.04.01) / 발행인 : 홍길동</div>
					<div>대표 : 홍길동 / 이메일 : email@mail.mail / 전화 : 01) 234-5678 /
						경기도 성남시 잘한다구 신난다동 345</div>
					<div class="footer-info-copywriter">Copyright(C)홍길동 All
						rights reserved.</div>
				</div>

			</div>
		</div>
	</div>

	<script>
		document.querySelectorAll(".sidebar-item").forEach(function(item) {
			item.addEventListener("click", function() {
				document.querySelectorAll(".sidebar-item").forEach(function(i) {
					i.classList.remove("_ov");
				});
				this.classList.add("_ov");
			});
		});
	</script>
</body>
</html>