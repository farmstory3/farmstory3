package com.farmstroy.Service;

import com.farmstroy.DAO.member.terms.TermsDAO;
import com.farmstroy.DTO.terms.TermsDTO;

public enum termsService{

	INSTANCE;
	
	private TermsDAO dao = TermsDAO.getInstance();
	
	// CRUD메서드
		public TermsDTO selectTerms() {
			
			return dao.selectTerms();
		}
}
