/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.26
 * Generated at: 2024-08-30 01:04:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>index</title>\r\n");
      out.write("</head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/farmstory/css/index.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/farmstory/css/footer.css\">\r\n");
      out.write("<style>\r\n");
      out.write("    ul, ol {list-style: none;}\r\n");
      out.write("    a {text-decoration: none; color: #111;}\r\n");
      out.write("    input, textarea {outline: none;}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"header-wrapper\">\r\n");
      out.write("    <div class=\"header-logo-box\">\r\n");
      out.write("        <div class=\"header-logo\"  onclick=\"location.href='/farmstory'\">\r\n");
      out.write("            <div class=\"logo-link-box\">\r\n");
      out.write("                <div class=\"logo-link\">\r\n");
      out.write("                    <div><a href=\"/farmstory\">Home</a></div>\r\n");
      out.write("                    <div>|</div>\r\n");
      out.write("                    <div><a href=\"/farmstory/market/cart.do\">장바구니</a></div>\r\n");
      out.write("                    <div>|</div>\r\n");
      out.write("                    <div><a href=\"/farmstory/member/login.do\">로그인</a></div>\r\n");
      out.write("                    <div>|</div>\r\n");
      out.write("                    <div><a href=\"/farmstory/admin/main.do\">관리자</a></div>\r\n");
      out.write("                    <div>|</div>\r\n");
      out.write("                    <div><a href=\"/farmstory/member/register.do\">회원가입</a></div>\r\n");
      out.write("                    <div>|</div>\r\n");
      out.write("                    <div><a href=\"/farmstory/community/qna.html\">고객센터</a></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"logo-add-box\">\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"header-side-box\">\r\n");
      out.write("        <div class=\"menu-1\"></div>\r\n");
      out.write("        <div class=\"menu-2\"></div>\r\n");
      out.write("        <div class=\"menu-3\"></div>\r\n");
      out.write("        <div class=\"menu-4\"></div>\r\n");
      out.write("        <div class=\"menu-5\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"header-menu-box\">\r\n");
      out.write("        <div>\r\n");
      out.write("            <div class=\"menu-gubun\"></div>\r\n");
      out.write("            <a href=\"/farmstory/introduction/hello.do\">\r\n");
      out.write("                <div class=\"menu-1 menu\"></div>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <div class=\"menu-gubun\"></div>\r\n");
      out.write("            <a href=\"/farmstory/market/list.do\">\r\n");
      out.write("                <div class=\"menu-2 menu\"><img src=\"/farmstory/images/head_menu_badge.png\" alt=\"badge\"></div>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <div class=\"menu-gubun\"></div>\r\n");
      out.write("            <a href=\"/farmstory/article/list.do?group=croptalk&cate=story\">\r\n");
      out.write("                <div class=\"menu-3 menu\"></div>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <div class=\"menu-gubun\"></div>\r\n");
      out.write("            <a href=\"/farmstory/article/list.do?group=event&cate=info\">\r\n");
      out.write("                <div class=\"menu-4 menu\"></div>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <div class=\"menu-gubun\"></div>\r\n");
      out.write("            <a href=\"/farmstory/article/list.do?group=community&cate=notice\">\r\n");
      out.write("                <div class=\"menu-5 menu\"></div>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"index-box\">\r\n");
      out.write("        <div class=\"main-slide\">\r\n");
      out.write("            <img src=\"./images/main_slide_img1.jpg\" alt=\"slide-img\" width=\"749px\" height=\"200px\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"popup\">\r\n");
      out.write("            <img src=\"./images/popup.png\" alt=\"popup\" width=\"229px\" height=\"200px\">\r\n");
      out.write("        </div>            \r\n");
      out.write("    </div>\r\n");
      out.write(" </div>\r\n");
      out.write(" <div class=\"main-container\">\r\n");
      out.write("    <div class=\"index-main-box1\">\r\n");
      out.write("        <img src=\"./images/main_market_tit.png\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"index-sub\">\r\n");
      out.write("        <div class=\"index-product-box1\">\r\n");
      out.write("            <img src=\"./images/market_item1.jpg\">\r\n");
      out.write("                <span class=\"text001\"><span>과일</span></span>\r\n");
      out.write("                <span class=\"text002\"><span>사과 500g</span></span>\r\n");
      out.write("            <div class=\"price-row\">\r\n");
      out.write("                <span class=\"text003\"><span>4000</span></span>\r\n");
      out.write("                <span class=\"text004\"><span>10%↓</span></span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <span class=\"text005\"><span>3,600원</span></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"index-product-box2\">\r\n");
      out.write("            <img src=\"./images/market_item2.jpg\">\r\n");
      out.write("            <span class=\"text006\"><span>과일</span></span>\r\n");
      out.write("            <span class=\"text007\"><span>사과 500g</span></span>\r\n");
      out.write("        <div class=\"price-row\">\r\n");
      out.write("            <span class=\"text008\"><span>4000</span></span>\r\n");
      out.write("            <span class=\"text009\"><span>10%↓</span></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <span class=\"text010\"><span>3,600원</span></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"index-product-box3\">\r\n");
      out.write("            <img src=\"./images/market_item3.jpg\">\r\n");
      out.write("            <span class=\"text011\"><span>과일</span></span>\r\n");
      out.write("            <span class=\"text012\"><span>사과 500g</span></span>\r\n");
      out.write("        <div class=\"price-row\">\r\n");
      out.write("            <span class=\"text013\"><span>4000</span></span>\r\n");
      out.write("            <span class=\"text014\"><span>10%↓</span></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <span class=\"text015\"><span>3,600원</span></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"index-product-box4\">\r\n");
      out.write("            <img src=\"./images/market_item4.jpg\">\r\n");
      out.write("            <span class=\"text016\"><span>과일</span></span>\r\n");
      out.write("            <span class=\"text017\"><span>사과 500g</span></span>\r\n");
      out.write("        <div class=\"price-row\">\r\n");
      out.write("            <span class=\"text018\"><span>4000</span></span>\r\n");
      out.write("            <span class=\"text019\"><span>10%↓</span></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <span class=\"text020\"><span>3,600원</span></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"index-product-box5\">\r\n");
      out.write("            <img src=\"./images/market_item5.jpg\">\r\n");
      out.write("            <span class=\"text021\"><span>과일</span></span>\r\n");
      out.write("            <span class=\"text022\"><span>사과 500g</span></span>\r\n");
      out.write("        <div class=\"price-row\">\r\n");
      out.write("            <span class=\"text023\"><span>4000</span></span>\r\n");
      out.write("            <span class=\"text024\"><span>10%↓</span></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <span class=\"text025\"><span>3,600원</span></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"index-product-box6\">\r\n");
      out.write("            <img src=\"./images/market_item6.jpg\">\r\n");
      out.write("            <span class=\"text026\"><span>과일</span></span>\r\n");
      out.write("            <span class=\"text027\"><span>사과 500g</span></span>\r\n");
      out.write("        <div class=\"price-row\">\r\n");
      out.write("            <span class=\"text028\"><span>4000</span></span>\r\n");
      out.write("            <span class=\"text029\"><span>10%↓</span></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <span class=\"text030\"><span>3,600원</span></span>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("        <div class=\"index_main_box2\">\r\n");
      out.write("            <div class=\"main_banner_box1\">\r\n");
      out.write("                <img src=\"./images/main_banner_sub1_tit.png\" alt=\"main_banner1\" width=\"190px\" height=\"50px\" style=\"margin-left: 10px;\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"main_banner_box2\">\r\n");
      out.write("                <img src=\"./images/main_banner_sub2_tit.png\" alt=\"main_banner2\" width=\"190px\" height=\"50px\" style=\"margin-left: 10px;\">\r\n");
      out.write("            </div>  \r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"index_main_box3\">\r\n");
      out.write("            <div class=\"extra_box1\">\r\n");
      out.write("                <img src=\"./images/main_latest1_tit.png\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"extra_box2\">\r\n");
      out.write("                <img src=\"./images/main_latest2_tit.png\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"extra_box3\">\r\n");
      out.write("                <img src=\"./images/main_latest3_tit.png\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"index_sub_box\">\r\n");
      out.write("            <div class=\"index_sub_box1\">\r\n");
      out.write("                <img src=\"./images/main_latest1_img.jpg\">\r\n");
      out.write("            </div>\r\n");
      out.write("                <div class=\"sub_text_box\">\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"sub_date\">\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            <div class=\"index_sub_box2\">\r\n");
      out.write("                <img src=\"./images/main_latest2_img.jpg\">\r\n");
      out.write("            </div>\r\n");
      out.write("                <div class=\"sub_text_box\">\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"sub_date\">\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            <div class=\"index_sub_box3\">\r\n");
      out.write("                <img src=\"./images/main_latest3_img.jpg\">\r\n");
      out.write("            </div>\r\n");
      out.write("                <div class=\"sub_text_box\">\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                    <a>>토마토! 건강하게길러...</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"sub_date\">\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                    <a>>20-12-20</a>\r\n");
      out.write("                </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"cs_wrapper\">\r\n");
      out.write("        <div class=\"main-gubun-box\"></div>\r\n");
      out.write("        <div class=\"customer_cs\">\r\n");
      out.write("            <div class=\"customer_cs_info\">\r\n");
      out.write("                <div class=\"cs_name\">\r\n");
      out.write("                <img src=\"./images/main_sub2_cs_tit.png\" alt=\"#1\" style=\"width: 80px; height: 17px; margin: 14px 0px;\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"cs_info\">\r\n");
      out.write("                    <img src=\"./images/main_sub2_cs_img.png\" alt=\"#2\" style=\"width: 61px; height: 43px;\">\r\n");
      out.write("                    <img src=\"./images/main_sub2_cs_txt.png\" alt=\"#3\" style=\"width: 125px; height: 39px; margin-left: 10px;\">\r\n");
      out.write("                    <div class=\"time\">\r\n");
      out.write("                     <p>평일: AM 09:00 ~ PM 06:00</p>\r\n");
      out.write("                     <p>점심: PM 12:00 ~ PM 01:00</p>\r\n");
      out.write("                     <p>토, 일요일, 공휴일 휴무</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"cs_btn\">\r\n");
      out.write("                    <img src=\"./images/main_sub2_cs_bt1.png\" style=\"float: left; margin: 10px 0;\">\r\n");
      out.write("                    <img src=\"./images/main_sub2_cs_bt2.png\" style=\"float: left; margin: 10px 0;\">\r\n");
      out.write("                    <img src=\"./images/main_sub2_cs_bt3.png\" style=\"float: left; margin: 10px 0;\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"account_info\">\r\n");
      out.write("                <img src=\"./images/main_sub2_account_tit.png\" style= \"margin: 13px;\">\r\n");
      out.write("                <div class=\"account_number\">\r\n");
      out.write("                    <p>기업은행 123-456789-01-01-012</p>\r\n");
      out.write("                    <p>국민은행 01-1234-56789</p>\r\n");
      out.write("                    <p>우리은행 123-456789-01-01-012</p>\r\n");
      out.write("                    <p>하나은행 123-456789-01-01</p>\r\n");
      out.write("                    <p>예 금 주 (주)팜스토리 </p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"notice\">\r\n");
      out.write("                <img src=\"./images/main_sub2_notice_tit.png\" style= \"margin: 13px;\">\r\n");
      out.write("                <div class=\"notice_box\">\r\n");
      out.write("                    <div class=\"notice_text_box\">\r\n");
      out.write("                        <li>안녕하세요. 홈페이지 오픈 기념 이벤트를 ...</li>\r\n");
      out.write("                        <li>안녕하세요. 홈페이지 오픈 기념 이벤트를 ...</li>\r\n");
      out.write("                        <li>안녕하세요. 홈페이지 오픈 기념 이벤트를 ...</li>\r\n");
      out.write("                        <li>안녕하세요. 홈페이지 오픈 기념 이벤트를 ...</li>\r\n");
      out.write("                        <li>안녕하세요. 홈페이지 오픈 기념 이벤트를 ...</li>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"notice_date\">\r\n");
      out.write("                        <p>20-12-20</p>\r\n");
      out.write("                        <p>20-12-20</p>\r\n");
      out.write("                        <p>20-12-20</p>\r\n");
      out.write("                        <p>20-12-20</p>\r\n");
      out.write("                        <p>20-12-20</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    </div> \r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"footer-wrapper\">\r\n");
      out.write("    <div class=\"footer-gubun-box\"></div>\r\n");
      out.write("    <div class=\"footer-main-box\">\r\n");
      out.write("        <div class=\"footer-logo-box\"></div>\r\n");
      out.write("        <div class=\"footer-info-box\">\r\n");
      out.write("            <div class=\"footer-info-detail\">\r\n");
      out.write("                <div>(주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제 2013-팜스토리구-123호 / 벤처기업확인 서울지방중소기업청 제 012345678-9-01234호</div>\r\n");
      out.write("                <div>등록번호 팜스토리01234 (2013.04.01) / 발행인 : 홍길동</div>\r\n");
      out.write("                <div>대표 : 홍길동 / 이메일 : email@mail.mail / 전화 : 01) 234-5678 / 경기도 성남시 잘한다구 신난다동 345</div>\r\n");
      out.write("                <div class=\"footer-info-copywriter\">Copyright(C)홍길동 All rights reserved.</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
