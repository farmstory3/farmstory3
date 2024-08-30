package com.farmstroy.DAO.member;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstroy.DTO.member.MemberDTO;
import com.farmstroy.util.DBHelper;
import com.farmstroy.util.SQL;


public class MemberDAO extends DBHelper{
	
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {};
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 public String select_uid(String email) {
	      String uid = null;
	      try {
	         conn = getConnection();
	         psmt = conn.prepareStatement(SQL.SELECT_UID);
	         psmt.setString(1, email);
	         rs = psmt.executeQuery();
	         
	         if(rs.next()) {
	            uid = rs.getString(1);
	         }
	         
	      } catch (Exception e) {
	         logger.error(e.getMessage());
	      } finally {
	         closeAll();
	      }
	      return uid;
	   }
	public int selectCountMember(String type, String value) {
		
		int result = 0;
		
		StringBuilder sql = new StringBuilder(SQL.SELECT_COUNT_MEMBER);
		
		if(type.equals("uid")) {
			sql.append(SQL.WHERE_UID);
		}else if(type.equals("nick")) {
			sql.append(SQL.WHERE_NICK);
		}else if(type.equals("email")) {
			sql.append(SQL.WHERE_EMAIL);
		}else if(type.equals("hp")) {
			sql.append(SQL.WHERE_HP);
		}
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, value);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	public void insertMember(MemberDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_MEMBER);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getNick());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, dto.getHp());
			psmt.setString(7, dto.getZip());
			psmt.setString(8, dto.getAddr1());
			psmt.setString(9, dto.getAddr2());
			psmt.setString(10, dto.getRegip());
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	};
	public MemberDTO selectMember(String uid, String pass) {
		MemberDTO user = null;
		try {
			conn = getConnection();
			psmt= conn.prepareStatement(SQL.SELELT_MEMBER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				user = new MemberDTO();
				user.setUid(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setName(rs.getString(3));
				user.setNick(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setHp(rs.getString(6));
				user.setRole(rs.getString(7));
				user.setZip(rs.getString(8));
				user.setAddr1(rs.getString(9));
				user.setAddr2(rs.getString(10));
				user.setRegip(rs.getString(11));
				user.setRegDate(rs.getString(12));
				user.setLeaveDate(rs.getString(13));
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return user;
	};
	
	public MemberDTO selectMemberDetail(String uid) {
		MemberDTO user = null;
		try {
			conn = getConnection();
			psmt= conn.prepareStatement(SQL.SELELT_MEMBER_DETAIL);
			psmt.setString(1, uid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				user = new MemberDTO();
				user.setUid(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setName(rs.getString(3));
				user.setNick(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setHp(rs.getString(6));
				user.setRole(rs.getString(7));
				user.setZip(rs.getString(8));
				user.setAddr1(rs.getString(9));
				user.setAddr2(rs.getString(10));
				user.setRegip(rs.getString(11));
				user.setRegDate(rs.getString(12));
				user.setLeaveDate(rs.getString(13));
				user.setPoint(rs.getInt(13));
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return user;
	};
	
	public List<MemberDTO> selectMembers() {
List<MemberDTO> users = new ArrayList<MemberDTO>();
		
		try {
			conn = getConnection();
			psmt= conn.prepareStatement(SQL.SELECT_MEMBERS);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO user = new MemberDTO();
				user.setUid(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setName(rs.getString(3));
				user.setNick(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setHp(rs.getString(6));
				user.setRole(rs.getString(7));
				user.setZip(rs.getString(8));
				user.setAddr1(rs.getString(9));
				user.setAddr2(rs.getString(10));
				user.setRegip(rs.getString(11));
				user.setRegDate(rs.getString(12));
				user.setLeaveDate(rs.getString(13));
				users.add(user);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		closeAll();
		return users;
	};
	
	public List<MemberDTO> selectMembersList(int start) {
		List<MemberDTO> users = new ArrayList<MemberDTO>();
		
		try {
			conn = getConnection();
			psmt= conn.prepareStatement(SQL.SELECT_MEMBERS_LIST);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO user = new MemberDTO();
				user.setUid(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setName(rs.getString(3));
				user.setNick(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setHp(rs.getString(6));
				user.setRole(rs.getString(7));
				user.setZip(rs.getString(8));
				user.setAddr1(rs.getString(9));
				user.setAddr2(rs.getString(10));
				user.setRegip(rs.getString(11));
				user.setRegDate(rs.getString(12));
				user.setLeaveDate(rs.getString(13));
				users.add(user);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		closeAll();
		return users;
	};
	
	public void updateMember(MemberDAO dto) {
		
	};
	public void deleteMember(String uid) {
		
	};
}
