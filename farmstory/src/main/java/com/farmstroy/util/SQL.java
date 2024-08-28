package com.farmstroy.util;

public class SQL {
	
	public static final String SELECT_TERMS = "select * from terms";
	public static final String SELECT_COUNT_USER = "SELECT COUNT(*) FROM `user` ";
	public static final String WHERE_UID  = "WHERE `uid`=?";
	public static final String WHERE_NICK = "WHERE `nick`=?";
	public static final String WHERE_EMAIL = "WHERE `email`=?";
	public static final String WHERE_HP = "WHERE `hp`=?";
	
	public static final String SELELT_USER = "select * from user where uid =? and pass=SHA2(?,256)";
	public static final String INSERT_USER = "insert into user set "
											+ "`uid` = ?, "
											+ "`pass` = SHA2(?, 256), "
											+ "`name` = ?, "
											+ "`nick` = ?, "
											+ "`email` = ?, "
											+ "`point` = 0, "
											+ "`hp` = ?, "
											+ "`zip` = ?, "
											+ "`addr1` = ?, "
											+ "`addr2` = ?, "
											+ "`regip` = ?, "
											+ "`regDate` = NOW()";
	// article
	public static final String INSERT_ARTICLE = "insert into article set "
												+ "`title`=?,"
												+ "`content`=?,"
												+ "`file`=?,"
												+ "`writer`=?,"
												+ "`regip`=?,"
												+ "`rdate`=NOW()";
	public static final String SELECT_MAX_NO = "select MAX(no) from article";
	public static final String SELECT_ARTICLES = "select a.*, b.nick from article as a "
												+"join user as b on a.writer = b.uid "
												+ "where a.group =? && a.cate= ? "
												+ "order by no desc limit ?, 10" ;
	public static final String SELECT_COUNT_TOTAL = "select count(*) from article "
												+ "where `group` =? && cate= ?";
	public static final String SELECT_ARTICLE = "select * from article as a "
												+ "left join file as b on a.no = b.ano "
												+ "where a.no = ?";
	public static final String UPDATE_ARTICLE_HIT_COUNT = "update article set hit = hit + 1 "
												+ "where no = ?";
	//comment
	public static final String INSERT_COMMENT = "insert into comment set "
												+ "parent =?, "
												+ "content =?, "
												+ "writer =?, "
												+ "regip =?, "
												+ "rdate =NOW() ";
	public static final String SELECT_COMMENT = "select * from comment where no = ?";
	public static final String SELECT_COMMENTS = "select a.*, b.nick from comment as a "
												+ "join user as b "
												+ "on a.writer = b.uid "
												+ "where parent = ? "
												+ "order by no";
	public static final String DELETE_COMMNET = "delete from comment where no = ?";
	public static final String UPDATE_COMMNET = "update comment set content =? where no=?";
	//file
	public static final String INSERT_FILE = "insert into file set "
											+ "ano = ?,"
											+ "oName = ?,"
											+ "sName = ?,"
											+ "rdate = NOW()";
	public static final String SELECT_FILE = "select * from file where fno=?";	
	public static final String UPDATE_FILE_DOWNLOAD_COUNT = "update file set download = download + 1 "
															+ "where fno = ?";

	
	public static final String SELECT_USERS = "select * from member order by regDate limit 3";
	public static final String SELECT_PRODUCTS = "select * from product order by regDate limit 3";
	public static final String SELECT_ORDERS = "SELECT O.order_idx, P.prod_name, O.price, O.quantity, P.deliveryFee, O.total_price, O.uid, O.order_rdate "
											 + "FROM `order` AS O "
											 + "JOIN `product` AS P "
											 + "ON O.prod_idx = P.prod_idx order by O.order_rdate limit 3";
	
	public static final String SELECT_PROD_LIST = "SELECT PF.`path`, PF.filename, P.prod_idx, P.prod_name, P.`type`, P.price, P.stock, P.regDate FROM product AS P JOIN product_file AS PF ON P.prod_idx = PF.prod_idx WHERE PF.`type` = 1";

	public static final String SELECT_MARKETPRODUCTS = "SELECT PF.`path`, PF.filename, P.prod_idx, P.prod_name, P.`type`, P.price, P.stock, P.regDate, P.point, P.discount FROM product AS P JOIN product_file AS PF ON P.prod_idx = PF.prod_idx WHERE PF.`type` = 1"; 
	
}
