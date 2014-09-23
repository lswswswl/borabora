<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/header.jsp" /><br>


<div class="panel panel-custom2">
	<div class="panel-body">

			
			<p class="pull-left">
				안녕하세요, @<b><%=session.getAttribute("nickname")%></b> 님 !
			</p>
	
			<a href="productForm.action" role="button" method="form"
				class="btn btn-round-lg2 btn-lg pull-right">상품 등록하기</a>	

	</div>
</div>



<jsp:include page="/my_page_tab.jsp" /><br>

<jsp:include page="/footer.jsp" />