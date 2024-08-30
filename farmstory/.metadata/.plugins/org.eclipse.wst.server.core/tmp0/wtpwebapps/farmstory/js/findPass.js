/**
 * 이클립스 Javascript 파일에서 semi-colon expected 에러가 발생 해결
 * - 이클립스 종료 후 {에러 발생한 workspace}\.metadata\.plugins\org.eclipse.core.resources\.projects\{프로젝트명} 이동 
 * - 해당 경로에 .markers 파일을 삭제 후 이클립스 재시작
 */
// 유효성 검사에 사용할 정규표현식
const reUid   = /^[a-z]+[a-z0-9]{4,19}$/g;
const rePass  = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{5,16}$/;
const reEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

// 유효성 검사에 사용할 상태변수
let isUidOk   = false;
let isPassOk  = false;
let isEmailOk = false;

window.onload = function(){
	
	const btnCheckUid = document.getElementById('btnCheckUid');
	const btnSendEmail = document.getElementById('btnSendEmail');
	const btnAuthEmail = document.getElementById('btnAuthEmail');
	const IdForm = document.getElementsByTagName('form')[0];
	const resultId = document.getElementsByClassName('resultId')[0];
	const resultPass = document.getElementsByClassName('resultPass')[0];
	const resultEmail = document.getElementsByClassName('resultEmail')[0];
	
	// 1.아이디 유효성 검사
		btnCheckUid.onclick = function(){
			
			const uid = registerForm.uid.value;
			
			// 아이디 유효성 검사
			if(!uid.match(reUid)){
				resultId.innerText = '아이디가 유효하지 않습니다.';
				resultId.style.color = 'red';
				return;
			}
			
			// 중복체크
			fetch('/farmstory/member/checkUser.do?type=uid&value='+uid)
				.then(resp => resp.json())
				.then(data => {
					console.log(data);
					
					if(data.result > 0){
						resultId.innerText = '이미 사용중인 아이디 입니다.';
						resultId.style.color = 'red';
						isUidOk = false;
					}else{
						resultId.innerText = '사용 가능한 아이디 입니다.';
						resultId.style.color = 'green';
						isUidOk = true;
					}
				})
				.catch(err => {
					console.log(err);
				});
		}
		
		// 5.이메일 유효성 검사
			let preventDblClick = false;
			
			btnSendEmail.onclick = async function(){
				
				//email은 찾을 아이디 멤버 데이터에 있는 이메일 
				const email = IdForm.email.value;
				
				// 이중 클릭 방지
				if(preventDblClick){
					return;
				}
				
				// 이메일 유효성 검사
				if(!email.match(reEmail)){
					resultEmail.innerText = '유효한 이메일이 아닙니다.';
					resultEmail.style.color = 'red';
					return;
				}
				
				try{
					preventDblClick = true;
					
					const response = await fetch('/farmstory/member/findId.do?type=email&value='+email);
					const data = await response.json();
					console.log(data);
					
					if(data.result > 0){
						resultEmail.innerText = '이메일 인증번호를 확인해주세요.';
						resultEmail.style.color = 'green';
						isEmailOk = false;
					}else{
						resultEmail.innerText = '회원가입시 등록한 이메일이 아닙니다.';
						resultEmail.style.color = 'red';
						auth.style.display = 'block';
					}
					
					
				}catch(e){
					console.log(e);
				}
			}
			
			btnAuthEmail.onclick = function(){
				
				const code = IdForm.auth.value;
				const email = IdForm.email.value;
				
				fetch('/farmstory/member/findId.do', {
						method: 'POST',
						body: JSON.stringify({"code":code,
											  "email" : email
											})
					})
					.then(resp => resp.json())
					.then(data => {
						console.log(data);
						
						if(data.result > 0){
							resultEmail.innerText = '이메일이 인증되었습니다.';
							resultEmail.style.color = 'green';
							isEmailOk = true;
							alert(data.pass);
						}else{
							resultEmail.innerText = '유효한 인증코드가 않습니다.';
							resultEmail.style.color = 'red';
							isEmailOk = false;
						}
					})
					.catch(err => {
						console.log(err);
					});
			}

}