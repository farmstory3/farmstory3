package service.validator;

import common.ResponseStatus;
import dto.requestDto.LoginRequestDto;
import dto.responsedto.ResponseDto;
import dto.responsedto.ResponseDtoImpl;

public class LoginValidator {
	
	// LoginRequestDto의 필드가 null 인지 검사(>입력을 안했을때)
	public ResponseDtoImpl validateInput(LoginRequestDto dto) {
		String id = dto.getUserId();
		String pw = dto.getUserPw();
		
		if(id == null || pw == null) {
			// 둘 중 하나라도 null이라면 VALIDATION_FAILED
			return new ResponseDtoImpl(ResponseStatus.VALIDATION_FAILED);
		}
		// 둘 다 값이 존재한다면 SUCCESS
		return new ResponseDtoImpl(ResponseStatus.SUCCESS);
	}
}
