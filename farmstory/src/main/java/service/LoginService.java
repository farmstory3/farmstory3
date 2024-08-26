package service;

import common.ResponseStatus;
import dao.UserDao;
import dto.requestDto.LoginRequestDto;
import dto.responsedto.ResponseDto;
import dto.responsedto.ResponseDtoImpl;
import service.validator.LoginValidator;
import vo.UserVo;

public class LoginService implements Service<LoginRequestDto>{
	private UserDao userDao;
	private LoginValidator validator;
	public LoginService(UserDao userDao, LoginValidator validator) {
		this.userDao = userDao;
		this.validator = validator;
	}
	
	@Override
	public ResponseDto handleService(LoginRequestDto requestDto) {
		UserVo user = userDao.findByUseriD(requestDto);
		String userId = user.getUserId();
		String userPw = user.getUserPw();
		String inputId = requestDto.getUserId();
		String inputPw = requestDto.getUserPw();
		
		ResponseDtoImpl inputValidator = validator.validateInput(requestDto); 
		
		if(inputValidator.getCode().equals(ResponseStatus.SUCCESS)) {
			if(!userId.equals(inputId)&& !userPw.equals(inputPw)) {
				return new ResponseDtoImpl(ResponseStatus.AUTHORIZATION_FAILED);
			}
		}
		return new ResponseDtoImpl(ResponseStatus.SUCCESS);
	}

}
