package com.farmstroy.DAO.member.terms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstroy.DTO.terms.TermsDTO;
import com.farmstroy.util.DBHelper;
import com.farmstroy.util.SQL;


public class TermsDAO extends DBHelper{
	private static TermsDAO instance = new TermsDAO();

	public static TermsDAO getInstance() {
		return instance;
	}

	private TermsDAO() {};


	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// CRUD메서드
	public TermsDTO selectTerms() {
		TermsDTO dto = new TermsDTO();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_TERMS);

			if(rs.next()) {
				dto = new TermsDTO();
				dto.setTerms(rs.getString(1));
				dto.setPrivacy(rs.getString(2));
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return dto;
	}
}
