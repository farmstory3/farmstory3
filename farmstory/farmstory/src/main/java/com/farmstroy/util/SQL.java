package com.farmstroy.util;

public class SQL {
	
	public static final String SELECT_TERMS = "select * from terms";
	public static final String SELECT_COUNT_MEMBER = "SELECT COUNT(*) FROM `member` ";
	public static final String WHERE_UID  = "WHERE `uid`=?";
	public static final String WHERE_NICK = "WHERE `nick`=?";
	public static final String WHERE_EMAIL = "WHERE `email`=?";
	public static final String WHERE_HP = "WHERE `hp`=?";
	public static final String SELECT_UID  = "select uid from member where email = ?";
	
	public static final String SELELT_MEMBER_DETAIL = "select * from member where uid =?";
	public static final String SELELT_MEMBER = "select * from member where uid =? and pass=SHA2(?,256)";
	public static final String INSERT_MEMBER = "insert into member set "
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
											+ "`group`=?,"
											+ "`cate`=?,"
											+ "`rdate`=NOW()";
	
	public static final String SELECT_MAX_NO = "select MAX(no) from article";
	
	public static final String SELECT_ARTICLES = "select a.*, b.nick from article as a "
												+"join member as b on a.writer = b.uid "
												+"where a.group =? && a.cate= ? "
												+"order by no desc limit ?, 10" ;
	public static final String SELECT_COUNT_TOTAL = "select count(*) from article "
												+ "where `group` =? && cate= ?";
	public static final String SELECT_ARTICLE = "select * from article as a "
												+ "left join article_file as b on a.no = b.ano "
												+ "where a.no = ?";
	public static final String UPDATE_ARTICLE_HIT_COUNT = "update article set hit = hit + 1 "
												+ "where no = ?";
	public static final String DELETE_ARTICLE = "delete from article where no = ?";
	//comment
	public static final String INSERT_COMMENT = "insert into comment set "
												+ "parent =?, "
												+ "content =?, "
												+ "writer =?, "
												+ "regip =?, "
												+ "rdate =NOW() ";
	public static final String SELECT_COMMENT = "select * from comment where no = ?";
	public static final String SELECT_COMMENTS = "select a.*, b.nick from comment as a "
												+ "join member as b "
												+ "on a.writer = b.uid "
												+ "where parent = ? "
												+ "order by no";
	public static final String DELETE_COMMNET = "delete from comment where no = ?";
	public static final String UPDATE_COMMNET = "update comment set content =? where no=?";
	//file
	public static final String INSERT_FILE = "insert into article_file set "
											+ "ano = ?,"
											+ "oName = ?,"
											+ "sName = ?,"
											+ "rdate = NOW()";
	public static final String SELECT_FILE = "select * from article_file where fno=?";	
	public static final String UPDATE_FILE_DOWNLOAD_COUNT = "update article_file set download = download + 1 "
															+ "where fno = ?";
	
	public static final String SELECT_MEMBERS = "select * from member order by regDate limit 3";
	public static final String SELECT_MEMBERS_LIST = "select * from member order by regDate desc limit ?, 10";
	public static final String SELECT_PRODUCT = "select PF.`path`, PF.filename, P.* from "
												+ "product as P JOIN product_file AS PF "
												+ "ON P.prod_idx = PF.prod_idx "
												+ "where P.prod_idx = ? && PF.TYPE IN(2, 3)"
												+ "order by PF.TYPE";
	public static final String SELECT_PRODUCTS = "select * from product order by regDate limit 3";
	public static final String SELECT_ORDERS = "SELECT O.order_idx, P.prod_name, O.price, O.quantity, P.deliveryFee, O.total_price, O.uid, O.order_rdate "
											 + "FROM `order` AS O "
											 + "JOIN `product` AS P "
											 + "ON O.prod_idx = P.prod_idx order by O.order_rdate limit 3";
	
	public static final String SELECT_PROD_LIST = "SELECT PF.`path`, PF.filename, P.prod_idx, P.prod_name, P.`type`, P.price, P.stock, P.regDate FROM product AS P JOIN product_file AS PF ON P.prod_idx = PF.prod_idx WHERE PF.`type` = 1";
	public static final String SELECT_PRODUCTS_ALL = "select * from product";
	public static final String SELECT_PROUDCT_FILE = "select * from product_file where prod_idx = ?  AND type = 1";
	public static final String INSERT_PRODUCT = "insert into product (prod_name, type, price, point, deliveryfee, discount, stock, etc) values(?,?,?,?,?,?,?,?)";
	public static final String INSERT_PRODUCT_FILE = "insert into product_file (prod_idx, filename, path, type) values (?,?,?,?)";
	
	                                
	public static final String SELECT_MARKETPRODUCTS = "SELECT PF.`path`, PF.filename, P.prod_idx, P.prod_name, P.`type`, P.price, P.stock, P.regDate, P.point, P.discount "
			+ "FROM product AS P JOIN product_file AS PF ON P.prod_idx = PF.prod_idx WHERE PF.`type` = 1 AND P.`type`=?"; 
	
	public static final String TEST = "SELECT PF.`path`, PF.filename, P.prod_idx, P.prod_name, P.`type`, P.price, P.stock, P.regDate, P.point, P.discount FROM product AS P JOIN product_file AS PF ON P.prod_idx = PF.prod_idx WHERE PF.`type` = 1 AND P.`type`=?";
	public static final String TEST2 = "select * from product_file";
	public static final String SELECT_MARKETPRODUCTS_COUNT = "select count(*) from product_file";
	public static final String SELECT_MARKETPRODUCTS_TYPE = "select DISTINCT(type) from product";
	
}
