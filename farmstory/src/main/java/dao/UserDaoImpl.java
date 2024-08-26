package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.DatabaseUtil;
import common.SqlQueries;
import dto.requestDto.LoginRequestDto;
import vo.UserVo;

public class UserDaoImpl implements UserDao {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserVo findByUseriD(LoginRequestDto requestDto) {
		UserVo user = null;
		try (Connection conn = DatabaseUtil.getConnection();
				PreparedStatement psmt =  conn.prepareStatement(SqlQueries.SELECT_USER_BY_USERID)){
			psmt.setString(1, requestDto.getUserId());
			
			try(ResultSet rs = psmt.executeQuery();){
				if(rs.next()) {
					user = new UserVo();
					user.setUserId(rs.getString("id"));
					user.setUserPw(rs.getString("pw"));
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return user;
	}

	

}
