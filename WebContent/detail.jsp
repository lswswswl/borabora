<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="/header.jsp"/>

<!-- 기본정보 -->
<div class="row">
	<div class="col-xs-6 col-sm-6 col-md-6 text-left">
		<a href="categoryList.action?currentPage=${currentPage}"><h5 class="product-subinfo">
		<span class="glyphicon glyphicon-list"></span>
		 목록보기</h5></a>
	</div>

	<div class="col-xs-6 col-sm-6 col-md-6 text-right">
		<h5 class="product-subinfo">
		 <span class="glyphicon glyphicon-eye-open"></span> <s:property value="resultClass.read_count"/>
		</h5>
	</div>
</div>

<h2 class="product-title">{ <s:property value="resultClass.title_p" /> }<br></h2>


<table class="product-info-area">
<tr>
<td class="product-info"><h4>가격</h4></td>
<td class="product-value"><h4><s:property value="resultClass.price" />₩</h4></td>
</tr>

<tr>
<td class="product-info"><h4>거래방법</h4></td>
<td class="product-value product-td"><h4>
<s:if test="resultClass.type_delivery!=null&&resultClass.type_direct!=null">
<s:property value="resultClass.type_direct"/>, 택배가능
</s:if>
<s:if test="resultClass.type_delivery!=null&&resultClass.type_direct==null">
<s:property value="resultClass.type_delivery"/>
</s:if>
<s:if test="resultClass.type_delivery==null&&resultClass.type_direct!=null">
<s:property value="resultClass.type_direct"/>
</s:if></h4></td>
</tr>

<tr>
<td class="product-info"><h4>거래지역</h4></td>
<td class="product-value"><h4>
<s:if test="resultClass.area!=null">
<s:property value="resultClass.area"/>
</s:if>
<s:if test="resultClass.type_delivery!=null&&resultClass.type_direct==null">
전국
</s:if>
</h4></td>
</tr>

</table>

<!-- 로그인 안해서 구매나 줄서기 액션 못취하는 경우 -->
<s:if test="#session.no_m == null">

<div class="row text-center">
<div class="col-xs-6 col-sm-6 col-md-6 text-right">
<s:if test ="resultClass.status_p==0" >
<a href="#" class="btn-login btn btn-round-lg1 btn-lg">
<span class="glyphicon glyphicon-shopping-cart"></span> 구매하기 </a>
</s:if>


<s:if test ="resultClass.status_p==1" >
<a href="#" class="btn-login btn btn-round-lg1 btn-lg">
<span class="glyphicon glyphicon-user"></span> 줄서기 </a>
</s:if>
</div>

<div class="col-xs-6 col-sm-6 col-md-6 text-left">
<%-- <s:if test="favoClass == null">
 --%>
<a href="#" class="btn-login btn btn-round-lg2 btn-lg">
<span class="glyphicon glyphicon-star"></span> 찜하기</a>
<%-- </s:if> --%>
</div>
</div>
</s:if>
<s:else>

<div class="row text-center">
<div class="col-xs-6 col-sm-6 col-md-6 text-right">

<!-- 로그인 해서 정상적으로 subtmit 하기 -->

<s:if test ="resultClass.status_p==0" >
<form action="productStatus.action" method="post">
<input type="hidden" name="no_p" value="${no_p}">
<input type="hidden" name="status_p" value="1">
<input type="hidden" name="currentPage" value="${currentPage}">
<button id="1st-notice" type="submit" class="btn btn-round-lg1 btn-lg">
  <span class="glyphicon glyphicon-shopping-cart"></span> 구매하기
</button>
</form>
</s:if>

<s:if test ="(resultClass.status_p==1||resultClass.status_p==2)&&myLineStatus==1">
<form action="deleteLine.action" method="post">
<input type="hidden" name="no_p" value="${no_p}">
<input type="hidden" name="currentPage" value="${currentPage}">
<button type="submit" class="btn btn-round-lg1 btn-lg">
  <span class="glyphicon glyphicon-shopping-cart"></span> 구매취소
</button>
</form>
</s:if>

<s:if test ="(resultClass.status_p==1||resultClass.status_p==2)&&myLineStatus==0">
<form action="productStatus.action" method="post">
<input type="hidden" name="no_p" value="${no_p}">
<input type="hidden" name="currentPage" value="${currentPage}">
<button id="line-notice" type="submit" class="btn btn-round-lg1 btn-lg">
  <span class="glyphicon glyphicon-user"></span> 줄서기
</button>  
</form>
</s:if>

<s:if test ="(resultClass.status_p==1||resultClass.status_p==2)&&myLineStatus!=0&&myLineStatus!=1">
<form action="deleteLine.action" method="post">
<input type="hidden" name="no_p" value="${no_p}">
<input type="hidden" name="currentPage" value="${currentPage}">
<button type="submit" class="btn btn-round-lg1 btn-lg">
  <span class="glyphicon glyphicon-user"></span> 줄서기취소
</button>
</form>
</s:if>

<s:if test = "resultClass.status_p==3" >
<h4>판매완료</h4>
</s:if>
</div>
<div class="col-xs-6 col-sm-6 col-md-6 text-left">
<!-- 찜하기 부분 -->
<s:if test="favoClass == null">
<form action="productFavorite.action" method="post">
<input type="hidden" name="no_p" value="${no_p }">
<input type="hidden" name="currentPage" value="${currentPage}">
<button id="fav-notice" type="submit" class="btn btn-round-lg2 btn-lg product-btn1">
  <span class="glyphicon glyphicon-star"></span> 찜하기
</button>
</form>
</s:if>

<s:if test="favoClass != null">
<form action="productFavoriteDel.action" method="post">
<input type="hidden" name="no_p" value="${no_p }">
<input type="hidden" name="currentPage" value="${currentPage}">
<button type="submit" class="btn btn-round-lg2 btn-lg">
<span class="glyphicon glyphicon-star"></span> 찜취소
</button>
</form>
</s:if>
</div>
</div>

</s:else>

<!-- 상품설명  -->
<br>
<div class="panel panel-custom">
  <div class="panel-body">
  <div class="col-sm-9 col-md-9 text-left">
    <h3 class="panel-title text-left">판매자 @<b><s:property value="resultClass.seller_info"/></b> 님의 상품 설명</h3>
  </div>
  <div class="col-sm-3 col-md-3 text-right">
    <h5 class="product-subinfo2 text-right">Date <s:property value="resultClass.reg_date_p" /></h5>
  </div>
  <br> 
    <h4 class="product-discription">"<s:property value="resultClass.content_p" />"</h4><br>
  </div>
  <s:if test = 'lineList.size() !=0'>
  <div class="panel-footer">
    <s:iterator value="lineList" status="stat"> 
	<span class="glyphicon glyphicon-user"></span><b> <s:property value="buyers_nickname"/></b> 님이 구매를 희망합니다.<br>
	</s:iterator>
  </div>
  </s:if>
</div>

<!-- 이미지 영역 -->
<div class="text-center side-margin-sm">
<!-- 추후에 image responsive로 바꿔줌 일단은 이미지가 작으니깐 auto로 ex : "img-rounded img-responsive center-block" -->
<img src="<s:property value="p_ImageVO.Main_image"/>" class="img-rounded img-responsive center-block"><br>
<s:if test='p_ImageVO.Image2!=null'>
<img src="<s:property value="p_ImageVO.Image2" />" class="img-rounded img-responsive center-block"><br>
</s:if>
<s:if test='p_ImageVO.Image3!=null'>
<img src="<s:property value="p_ImageVO.Image3" />" class="img-rounded img-responsive center-block"><br>
</s:if>
<s:if test='p_ImageVO.Image4!=null'>
<img src="<s:property value="p_ImageVO.Image4" />" class="img-rounded img-responsive center-block"><br>
</s:if>
<s:if test='p_ImageVO.Image5!=null'>
<img src="<s:property value="p_ImageVO.Image5" />" class="img-rounded img-responsive center-block"><br>
</s:if>
</div>


<%-- 
리뷰 부분 나중에 마이페이지에서 쓸수있게 이동
<s:if test='reviewVO.no_r!=null'>
제목 : <s:property value="reviewVO.title_r" />&nbsp;
글쓴이 : <s:property value="reviewVO.reviewer_info"/>&nbsp;
등록일자 : <s:date name="reviewVO.reg_date_r" format="yyyy.MM.dd - hh:mm" /><br>
<img src="<s:property value="reviewVO.image_r"/>" style="width: 300px; height: auto;"><br> 
* 내용 *<br>
<s:property value="reviewVO.content_r" /><br>
</s:if>
<s:else>
후기가 없으니 등록해주세요^^<br>
<a href="reviewForm.action?no_p=<s:property value="no_p"/>">리뷰 작성</a>
</s:else>
 --%>

<script type="text/javascript">
document.getElementById("1st-notice").onclick=function(){
		 alert('첫번째로 구매의향을 표시하셨습니다! \n판매자에게 연락해 보세요. \n판매자의 번호는 마이페이지에서 확인할 수 있습니다.');
};	
</script>

<script type="text/javascript">
document.getElementById("line-notice").onclick=function(){
	 alert('줄서기가 완료되었습니다! \n판매자의 연락을 기다려 보세요. \n줄서신 상품 목록은 마이페이지에서 확인할 수 있습니다.');
};
</script>

<script type="text/javascript">
document.getElementById("fav-notice").onclick=function(){
	 alert('상품을 찜했습니다. \n찜한 상품 목록은 마이페이지에서 확인할 수 있습니다. ');
};
</script>



<jsp:include page="/p_comment.jsp"/>

<jsp:include page="/footer.jsp"/>