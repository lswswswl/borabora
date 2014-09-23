<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  

<h2 class="index-lg">찜한 상품</h2> 
<div class="row">
<s:iterator value="plist" status="stat">
<s:url id="viewURL" action="productRead">
<s:param name="no_p">
	<s:property value="no_p" />
</s:param>
<s:param name="currentPage">
	<s:property value="currentPage"/>
</s:param>
</s:url>

<s:url id="favoriteDel" action="productFavoriteDel_list">
	<s:param name="no_p">
		<s:property value="no_p" />
	</s:param>
	<s:param name="currentPage">
		<s:property value="currentPage"/>
	</s:param>
</s:url>

  <div class="col-xs-6 col-sm-4 col-md-4">
    <div class="thumbnail">
      <s:a href="%{viewURL}">
      <img src="<s:property value="main_image"/>">
      </s:a>
      <div class="caption">
        <h4><s:a href="%{viewURL}"><s:property value="title_p"/></s:a></h4>
        <p><s:property value="price"/>₩</p>
        <p>@<s:property value="seller_info"/><s:if test="status_p==1"><span class="badge-custom pull-right">예약중</span></s:if></p>
        <p class="text-right"><s:a href="%{favoriteDel}"><span class="glyphicon glyphicon-trash delete-button2"></span></s:a></p>      
      </div>
    </div>
  </div>
  		</s:iterator>
</div>

	<s:if test="plist.size() <= 0">
		찜하신 상품이 없습니다.
	</s:if>

