<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="carousel-example-generic" class="carousel slide hidden-xs" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="img/promotion1.jpg" alt="image1">
      <div class="carousel-caption carousel-position1">
      	<h3 class="text-left">쌓아만 두지 말고 <br> 파세요</h3>
      	
      	<s:if test="#session.no_m == null">
      		<a class="btn-login btn btn-clear pull-left" href="#" role="button"><h4><b>상품 등록하기</b></h4></a>
      	</s:if><s:else>
           <a class="btn btn-clear pull-left" href="productForm.action" role="button"><h4><b>상품 등록하기</b></h4></a>
		</s:else>	      
      </div>
    </div>
    <div class="item">
      <img src="img/promotion2.jpg" alt="image1">
      <div class="carousel-caption carousel-position2 hidden-xs">
        <h2>any time, any where, <br>with any device</h2>
      	<s:if test="#session.no_m == null">
      		<a class="btn-login btn btn-clear btn-sm btn-min-block" href="#" role="button"><h4><b>상품 등록하기</b></h4></a>
      	</s:if><s:else>
           <a class="btn btn-clear btn-sm btn-min-block" href="productForm.action" role="button"><h4><b>상품 등록하기</b></h4></a>
		</s:else>      
		</div>
    </div>
    <div class="item">
      <img src="img/promotion3.jpg" alt="image3" >
      <div class="carousel-caption carousel-position3 hidden-xs">
        <h3>휴대폰번호 전체공개는 NO!  <br> 구매자에게만 알려주세요</h3>
              	<s:if test="#session.no_m == null">
      		<a class="btn-login btn btn-clear btn-sm btn-min-block" href="#" role="button"><h4><b>상품 등록하기</b></h4></a>
      	</s:if><s:else>
           <a class="btn btn-clear btn-sm btn-min-block" href="productForm.action" role="button"><h4><b>상품 등록하기</b></h4></a>
		</s:else>
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div>  

<div class="panel panel-custom2 text-center hidden-sm hidden-md hidden-lg">
<s:if test="#session.no_m == null">
      	<a href="#" class="btn-login" role="button"><h4>지금 BoraBora에 상품 등록하기</h4></a>
</s:if><s:else>
		<h4><a href="productForm.action">지금 BoraBora에 상품 등록하기</a></h4>
</s:else>	 
</div>




  