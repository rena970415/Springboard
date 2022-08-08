<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Board</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/resources/assets/css/main.css" />
<style>
body {	transform: scale(0.8);}
.small-width{display : none;}
.big-width{display:block;}
	@media(max-width: 918px){
		body {	transform: scale(1); overflow-x: hidden;}
		
		.writer{display: none;}		
		.regDate{display: none;}		
		.updateDate{display: none;}
		.big-width{display:none;}
		.small-width{display:block;}		
	}

</style>
</head>
<body class="is-preload">
	<!-- Main -->
	<div id="main">
		<div class="wrapper">
			<div class="inner">

				<!-- Elements -->
				<header class="major">
					<h1>Board</h1>
					<p>게시판 목록</p>
				</header>
				<!-- Table -->
				<h3>
					<a href="/board/register" class="button small">글 등록</a>
				</h3>
				<div class="table-wrapper">
					<table>
						<thead>
							<tr class="tHead">
								<th class="bno">번호</th>
								<th class="title">제목</th>
								<th class="writer">작성자</th>
								<th class="regDate">작성일</th>
								<th class="updateDate">수정일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="board" items="${boardList}">
								<tr class="tBody">
									<td class="bno">${board.bno}</td>
									<td class="title"><a href="/board/read?bno=${board.bno}">${board.title}</a></td>
									<td class="writer">${board.writer}</td>
									<td class="regDate">${board.regDate}</td>
									<td class="updateDate">${board.updateDate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div style="text-align: center;" class="big-width">
							<c:if test="${pageDTO.prev}">
								<a class="changePage" href="${pageDTO.startPage - 1}"><code>&lt;</code></a>
							</c:if>
							<c:forEach var="num" begin="${pageDTO.startPage}" end="${pageDTO.endPage}">
								<c:choose>
									<c:when test="${pageDTO.criteria.pageNum == num}">
										<code><c:out value="${num}"/></code>
									</c:when>
									<c:otherwise>
										<a class="changePage" href="${num}"><code><c:out value="${num}"/></code></a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${pageDTO.next}">
								<a class="changePage" href="${pageDTO.endPage + 1}"><code>&gt;</code></a>
							</c:if>
						</div>
						<div style="text-align: center;" class="small-width">
							<c:if test="${pageDTO.criteria.pageNum > 1}">
								<a class="changePage" href="${pageDTO.criteria.pageNum - 1}"><code>&lt;</code></a>
							</c:if>
							<code><c:out value="${pageDTO.criteria.pageNum}" /></code>
							<c:if test="${pageDTO.realEnd > pageDTO.criteria.pageNum}">
								<a class="changePage" href="${pageDTO.criteria.pageNum + 1}"><code>&gt;</code></a>
							</c:if>
						</div>
						<form name="pageForm" action="/board/list">
							<input type="hidden" name="pageNum" value="${pageDTO.criteria.pageNum}">
						</form>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- Scripts -->
<script src="/resources/assets/js/jquery.min.js"></script>
<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
<script src="/resources/assets/js/browser.min.js"></script>
<script src="/resources/assets/js/breakpoints.min.js"></script>
<script src="/resources/assets/js/util.js"></script>
<script src="/resources/assets/js/main.js"></script>
<script >
// 페이지 이동을 하기위해 a태그를 클릭하면 이벤트 실행
	$("a.changePage").on("click",function(e){
		e.preventDefault();
		// from태그 가져오기
		let  $form =$(document.pageForm);
		// form태그 자식 요소 중 pageNum이 이름인 input태그 가져오기
		// 기존의 value 값을 사용자가 이동하고자 하는 페이지 번호로 이동하기
		$form.find("input[name='pageNum']").val($(this).attr("href"));
		$form.submit();
	});
</script>



</html>