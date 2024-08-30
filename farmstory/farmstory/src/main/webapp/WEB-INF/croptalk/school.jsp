<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>귀농학교</title>
<script>
    	window.onload = function(){
    		const commentForm = document.commentForm;
    		const commentList = document.getElementsByClassName('commentList')[0];
    		const commentUpdate = document.getElementsByClassName('commentUpdate');
   
    		
    	 	for(const btnUpdate of commentUpdate){
    			btnUpdate.style.display ='none';	
    		}
    			
    		let originalText = '';
    		
    		//동적 이벤트 처리
    		document.addEventListener('click', function(e){
    
    			const article = e.target.closest('article');
				const textarea = article.querySelector('textarea');
				
						
   	
				const no = e.target.dataset.no;
				const comment = textarea.value;
				
    			const formData = new FormData();
   
    			
    			formData.append("no", no);
    			formData.append("comment", comment);
    			
    			
    			// 댓글 수정완료
    			if(e.target.classList == 'commentUpdate'){
    				e.preventDefault();
    				const btndiv = e.target.closest('div');
    				const Update = btndiv.querySelector('.commentUpdate');	
    				const Modify = btndiv.querySelector('.commentModify');	
    				fetch('/farmstory/comment/modify.do', {
    					method: 'POST',
    					body: formData
    				})
    				.then(resp => resp.json())
    				.then(data => {
    					if(data.result > 0){
    						alert('댓글이 수정되었습니다.');
    						
    						textarea.readOnly = true;
            				textarea.style.background = 'transparent';
            				textarea.style.border = 'none';
            				Modify.innerText = '수정';
            				Update.style.display ='none';
    					}else {
    						alert('댓글 수정이 실패 되었습니다.');
    					}
    				
    				})
    				.catch(err => {
    					console.log(err);
    				});	
    			}
    			
    			// 수정 & 취소
    			if(e.target.classList == 'commentModify'){
    				e.preventDefault();
    				
    				const article = e.target.closest('article');
    				const textarea = article.querySelector('textarea');
    				
    				const mode = e.target.innerText;
    				const btndiv = e.target.closest('div');
    				const Update = btndiv.querySelector('.commentUpdate');			

    				if(mode == '수정') {
    					Update.style.display ='inline-block';		
    					originalText = textarea.value;
    					
    					textarea.readOnly = false;
        				textarea.style.background = 'white';
        				textarea.style.border = '1px solid #efefef';
        				textarea.focus();
        				e.target.innerText = '취소';
    				} else {
    					Update.style.display ='none';
    					textarea.value = originalText;
    					textarea.readOnly = true;
        				textarea.style.background = 'transparent';
        				textarea.style.border = 'none';
        				e.target.innerText = '수정';
    				}
    				
    			}
    			
    			// 댓글 삭제
    			if(e.target.classList == 'commentRemove'){
    				e.preventDefault();

    				if(!confirm('정말 삭제 하시겠습니까?')){
        				return;
        				}
        				
        				const no = e.target.dataset.no; // a태그 data-no 속성 값 가져오기
        				const article = e.target.closest('article');
        				
        				fetch('/farmstory/comment/delete.do?no='+no)
        					.then(resp => resp.json())
        					.then(data => {
        						if(data.result > 0){
        							alert('댓글이 삭제되었습니다.')
        							
        							//동적 삭제 처리
        							article.remove();
        							
        						} else{
        							alert('댓글이 삭제가 실패되었습니다.')
        						}
        						console.log(data);
        					})
        					.catch(err => {
        						console.log(err);
        					});
    				}
    			
    		});

    		//댓글 등록
    		commentForm.onsubmit = function(e){
    			e.preventDefault();
    			
    			const parent = commentForm.parent.value;
    			const writer = commentForm.writer.value;
    			const comment = commentForm.comment.value;
    			
    			//폼 데이터 생성
    			const formData = new FormData();
    			formData.append("parent", parent);
    			formData.append("writer", writer);
    			formData.append("comment", comment);

    			fetch('/farmstory/comment/write.do',{
    				method: 'POST',
    				body: formData
   
    			})
    				.then(resp => resp.json())	
    				.then(data => {
    					
    					if(data != null){
    						alert('댓글 등록');
    						// 등록한 댓글 동적 태그 생성
    						const commentArticle = `
					    						<article class="comment">
					    	                        <span>
					    	                            <span>\${data.rdate}</span>
					    	                            <span>\${data.writer}</span>
					    	                        </span>
					    	                        <textarea name="comment" readonly>\${data.content}</textarea>
					    	                        <div>
						    	                        <a href="#" class="commentRemove" data-no=\${data.no}>삭제</a>
							                            <a href="#" class="commentModify" data-no=\${data.no}>수정</a>
							                            <a href="#" class="commentUpdate" data-no=\${data.no} style='display: none'>수정완료</a>
					    	                        </div>
					    	                    </article>`;
    						commentList.insertAdjacentHTML('beforeend', commentArticle);
    						
    					} else{
    						alert('댓글 등록이 실패했습니다.');
    					}
    					colsole.log(data);
    				})
    				.catch(err => {
    					colsole.log(err);	
    				});
    		}
    		
    	
    	}
    </script>
</head>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/school.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/footer.css">
<link rel="stylesheet" href="/farmstory/css/write_style.css">
<body>
	<jsp:include page="/layout/_header.jsp" />
	<div class="header-bottom-img">
		<div class="header-bottom-comm">
			<img src="/farmstory/images/sub_top_tit3.png" alt="bottom-img">  <!-- 수정 -->
		</div>
	</div>
</div>
	<div class="main-wrapper">
		<div class="sidebar-box">
			<div class="sidebar-logo-box">
				<div class="sidebar-logo"></div>
			</div>
			<div class="sidebar-bg-box">
				<a href="/farmstory/article/list.do?group=croptalk&cate=story">
					<div class="sidebar-item _01"></div>
				</a> <a href="/farmstory/article/list.do?group=croptalk&cate=grow">
					<div class="sidebar-item _02"></div>
				</a> <a href="/farmstory/article/list.do?group=croptalk&cate=school">
					<div class="sidebar-item _03 _ov"></div>
				</a>
			</div>
		</div>
		<div class="sidebar-gubun-box"></div>





		<div class="main-box">
			<div class="main-title-box">
				<div class="main-title"></div>
				<div class="main-nav-box">
					<div class="nav-icon-box">
						<div class="nav-icon"></div>
					</div>
					<div class="nav-tit-1">Home</div>
					<div class="nav-latest-icon">></div>
					<div class="nav-tit-2">농작물이야기</div>
					<div class="nav-latest-icon">></div>
					<div class="nav-tit-3">귀농학교</div>
				</div>
			</div>
			<div class="main-gubun-box"></div>
			<c:choose>
			<c:when test="${write.equals(write)}">
				<main>
					<section class="write">
						<h3>글쓰기</h3>
						<article>
							<!-- 
                		multipart/form-data로 데이터 및 파일 전송을 위해 톰캣 설정해야됨 안하면 getParameter 수신 안됨
                		 - 톰캣 context.xml > Context 태그에 allowCasualMultipartParsing="true" 설정
						 - 톰캣 server.xml > Connector 태그에 maxPostSize="10485760" (1024 x 1024 x 10 = 10MB) 설정                		
                	-->
							<form
								action="/farmstory/article/write.do?write=write&group=croptalk&cate=school"
								method="post" enctype="multipart/form-data">
								<input type="hidden" id="writer" name="writer"
									value="${sessUser.uid}">
								<table>
									<tr>
										<td>제목</td>
										<td><input type="text" id="title" name="title"
											placeholder="제목을 입력하세요." /></td>
									</tr>
									<tr>
										<td>내용</td>
										<td><textarea id="content" name="content"></textarea></td>
									</tr>
									<tr>
										<td>첨부</td>
										<td>
											<p style="margin-bottom: 6px;"></p> <input type="file"
											id="file" name="file" />
										</td>
									</tr>
								</table>
								<div class="form-buttons">

									<!-- 취소 버튼 -->
									<!-- <button type="button" class="cancel-btn">취소</button> -->
									<a href="/farmstory/article/list.do?group=croptalk&cate=school"
										class="btnWrite">취소</a>

									<!-- 작성완료 버튼 -->
									<button type="submit" class="submit-btn">작성완료</button>

								</div>

							</form>
						</article>
					</section>
				</main>
			</c:when>
			<c:when test="${view.equals(view)}">
				<main>
			<section class="view">
				<h3>글보기</h3>
				<table>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title"
							value="${articleDto.title}" readonly /></td>
					</tr>
					<c:if test="${articleDto.file > 0}">
						<tr>
							<td>첨부파일</td>
							<c:forEach var="file" items="${articleDto.files}">
								<td><a
									href="/farmstory/article/fileDownload.do?fno=${file.fno}">${file.oName}</a>
									<span>${file.download}회 다운로드</span></td>
							</c:forEach>
						</tr>
					</c:if>
					<tr>
						<td>내용</td>
						<td><textarea name="content" readonly>${articleDto.content}</textarea>
						</td>
					</tr>
				</table>
				<div>
					<a href="/farmstory/article/delete.do?group=croptalk&cate=school&pg=${pg}&no=${articleDto.no}" class="btnDelete">삭제</a> <a href="#" class="btnModify">수정</a>
					<a href="/farmstory/article/list.do?group=croptalk&cate=school&pg=${pg}" class="btnList">목록</a>
				</div>

				<!-- 댓글리스트 -->
				<section class="commentList">
					<h3>댓글목록</h3>
					<c:forEach var="comment" items="${comments}">
						<article class="comment">
							<span> <span>${comment.rdate}</span> <span>${comment.nick}</span>
							</span>
							<textarea name="comment" readonly>${comment.content}</textarea>
							<c:if test="${sessUser.uid eq comment.writer}">
								<div>
									<!--  HTML 사용자 정의 속성을 이용한 삭제/수정 -->
									<a href="#" class="commentRemove" data-no="${comment.no}">삭제</a>
									<a href="#" class="commentModify" data-no="${comment.no}">수정</a>
									<a href="#" class="commentUpdate" data-no="${comment.no}">수정완료</a>
								</div>
							</c:if>
						</article>
					</c:forEach>
					<c:if test="${empty comments}">
						<p class="empty">등록된 댓글이 없습니다.</p>
					</c:if>
				</section>

				<!-- 댓글입력폼 -->
				<section class="commentForm">
					<h3>댓글쓰기</h3>
					<form name="commentForm">
						<input type="hidden" name="parent" value="${articleDto.no}" /> <input
							type="hidden" name="writer" value="${sessUser.uid}" />
						<textarea name="comment"></textarea>
						<div>
							<a href="#" class="btnCancel">취소</a> <input type="submit"
								class="btnWrite" value="작성완료" />
						</div>
					</form>
				</section>

			</section>
		</main>
			</c:when>
			<c:otherwise>
				<section class="list">
					<h3>글목록</h3>
					<article>
						<table border="0">
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>날짜</th>
								<th>조회</th>
							</tr>
							<c:forEach var="article" items="${articles}">
								<tr>
									<td>${pageStartNum}</td>
									<td><a href="/farmstory/article/view.do?group=croptalk&cate=school&view=view&no=${article.no}&pg=${currentPageNum}"">${article.title}</a>&nbsp;[${article.comment}]</td>
									<td>${article.nick}</td>
									<td>${article.rdate}</td>
									<td>${article.hit}</td>
								</tr>
								<!-- 한번 반복할때마다 pageStartNum을 1씩 차감 -->
								<c:set var="pageStartNum" value="${pageStartNum-1}" />
							</c:forEach>
						</table>
					</article>

					<!-- 페이지 네비게이션 -->
					<div class="paging">
						<c:if test="${pageGroup.start > 1}">
							<a href="/jboard/article/list.do?pg=${pageGroup.start - 1}"
								class="prev">이전</a>
						</c:if>
						<c:choose>
							<c:when test="${pageGroup.end > pageLastNum}">
								<c:forEach var="i" begin="${pageGroup.start}"
									end="${pageLastNum}">
									<a href="/jboard/article/list.do?pg=${i}"
										class="num ${currentPageNum == i ? 'current':'off'}">${i}</a>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="i" begin="${pageGroup.start}"
									end="${pageGroup.end}">
									<a href="/jboard/article/list.do?pg=${i}"
										class="num ${currentPageNum == i ? 'current':'off'}">${i}</a>
								</c:forEach>
								<a href="/jboard/article/list.do?pg=${pageGroup.end + 1}"
									class="next">다음</a>
							</c:otherwise>
						</c:choose>
					</div>

					<!-- 글쓰기 버튼 -->
					<a
						href="/farmstory/article/write.do?write=write&group=croptalk&cate=school"
						class="btnWrite">글쓰기</a>
				</section>
			</c:otherwise>
			</c:choose>

		</div>

	</div>
	<jsp:include page="/layout/_footer.jsp" />	
</body>
</html>