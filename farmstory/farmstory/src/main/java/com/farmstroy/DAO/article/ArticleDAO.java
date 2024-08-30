package com.farmstroy.DAO.article;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstroy.DTO.article.articleDTO;
import com.farmstroy.DTO.article.fileDTO;
import com.farmstroy.DTO.article.groupDTO;
import com.farmstroy.util.DBHelper;
import com.farmstroy.util.SQL;



public class ArticleDAO extends DBHelper{
	private static ArticleDAO instance = new ArticleDAO();

	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO() {};

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public int insertArticle(articleDTO dto) {
		int no = 0;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getFile());
			psmt.setString(4, dto.getWriter());
			psmt.setString(5, dto.getRegip());
			psmt.setString(6, dto.getGroup());
			psmt.setString(7, dto.getCate());
			psmt.executeUpdate();
			
			rs = stmt.executeQuery(SQL.SELECT_MAX_NO);
			if (rs.next()) {
				no = rs.getInt(1);
			}
			conn.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error(e1.getMessage());
			}
		}finally {
			closeAll();
		}
		
		return no;
	}

	public int selectCountTotal(groupDTO groupdto) {
		int total = 0 ;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_TOTAL);
			psmt.setString(1, groupdto.getGroup());
			psmt.setString(2, groupdto.getCate());
			rs = psmt.executeQuery();

			if(rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			closeAll();
		}
		return total;
	}
	
	public int selectCountTotalMember() {
		int total = 0 ;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from member");
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			closeAll();
		}
		return total;
	}
	
	public articleDTO selectArticle(String no) {
		articleDTO dto =  null;
		List<fileDTO> files = new ArrayList<fileDTO>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLE);
			psmt.setString(1, no);

			rs = psmt.executeQuery();

			while(rs.next()) {
				// 한개의 게시물에 2개이상에 파일이 있을때 다시 dto가 초기화되므로 자원낭비 방지
				if(dto == null) {
					dto =  new articleDTO();
					dto.setNo(rs.getInt("no"));
					dto.setCate(rs.getString("cate"));
					dto.setGroup(rs.getString("group"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setComment(rs.getInt("comment"));
					dto.setFile(rs.getInt("file"));
					dto.setHit(rs.getInt("hit"));
					dto.setWriter(rs.getString("writer"));
					dto.setRegip(rs.getString("regip"));
					dto.setRdate(rs.getString("rdate"));
				}
				
				com.farmstroy.DTO.article.fileDTO fdto = new com.farmstroy.DTO.article.fileDTO();
				fdto.setFno(rs.getInt(12));
				fdto.setAno(rs.getInt(13));
				fdto.setoName(rs.getString(14));
				fdto.setsName(rs.getString(15));
				fdto.setDownload(rs.getInt(16));
				fdto.setRdate(rs.getString(17));
				files.add(fdto);
			}
			dto.setFiles(files); 
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			closeAll();
		}

		return dto;
	}
	public List<articleDTO> selectArticles(groupDTO groupdto ,int start) {
		List<articleDTO> dtos = new ArrayList<articleDTO>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLES);
			psmt.setString(1, groupdto.getGroup());
			psmt.setString(2, groupdto.getCate());
			psmt.setInt(3, start);
			rs = psmt.executeQuery();

			while(rs.next()) {
				articleDTO dto = new articleDTO();
				dto.setNo(rs.getInt(1));
				dto.setGroup(rs.getString(2));
				dto.setCate(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setComment(rs.getInt(6));
				dto.setFile(rs.getInt(7));
				dto.setHit(rs.getInt(8));
				dto.setWriter(rs.getString(9));
				dto.setRegip(rs.getString(10));
				dto.setRdateSub(rs.getString(11));
				dto.setNick(rs.getString(12));
				dtos.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
		return dtos;
	}
	
	public void updateArticleHitCount(String no) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_ARTICLE_HIT_COUNT);
			psmt.setString(1, no);
			psmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeAll();
		}
	}
	public void updateArticle(ArticleDAO dto) {

	}
	public int deleteArticle(int no) {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_ARTICLE);
			psmt.setInt(1, no);
			result = psmt.executeUpdate();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			closeAll();
		}
		
		return result;
	}
	
}

