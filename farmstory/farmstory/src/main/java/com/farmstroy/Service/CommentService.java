package com.farmstroy.Service;

import java.util.List;

import com.farmstroy.DAO.comment.CommentDAO;
import com.farmstroy.DTO.comment.CommentDTO;

public enum CommentService {
	
	INSTANCE;
	private CommentDAO dao = CommentDAO.getInstance();
	
	public int insertComment(CommentDTO dto) {
		return dao.insertComment(dto);
	}
	public CommentDTO selectComment(int no) {
		return dao.selectComment(no);
	}
	public List<CommentDTO> selectComments(String parent) {
		return dao.selectComments(parent);
	}
	public int updateComment(CommentDTO dto) {
		return dao.updateComment(dto);
	}
	public int deleteComment(String no) {
		return dao.deleteComment(no);
	}
}