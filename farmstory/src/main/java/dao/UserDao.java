package dao;

import dto.requestDto.LoginRequestDto;
import vo.UserVo;

public interface UserDao {

	public UserVo findByUseriD(LoginRequestDto requestDto);
}
