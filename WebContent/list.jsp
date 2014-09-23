<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.HashMap" %> 
   
<jsp:include page="/header.jsp"/>

<style>
  .input-group .form-control.select-sw{
    width:100px;
  }
  </style>
  
  <form>
    <div class="input-group">
      <div class="input-group-btn">
        <select name="searchNum" class="form-control select-sw">
          <option value="1">상품명</option>
          <option value="0">판매자</option>
          <option value="2">내용</option>
        </select>
      </div><!-- /btn-group -->
      
      <input type="text" name="searchKeyword" class="form-control form-control3" placeholder="검색어를 입력해 주세요...">
    		<span class="input-group-btn">
            <button class="btn btn-round-sm3" type="submit">
            <span class="glyphicon glyphicon-search"></span>
            </button>
            </span>      
    </div><!-- /input-group -->
</form>



<h3>상품 리스트</h3>
<div class="row">
<s:iterator value="list" status="stat">
<s:url id="viewURL" action="productRead">
<s:param name="no_p">
	<s:property value="no_p" />
</s:param>
<s:param name="currentPage">
	<s:property value="currentPage"/>
</s:param>
</s:url>
  <div class="col-xs-6 col-sm-6 col-md-4">
    <div class="thumbnail">
      <s:a href="%{viewURL}">
      <img src="<s:property value="main_image"/>">
      </s:a>
      <div class="caption">
        <h4><s:a href="%{viewURL}"><s:property value="title_p"/></s:a></h4>
        <p><s:property value="price"/>₩</p>
        <p>@<s:property value="seller_info"/><s:if test="status_p==1"><span class="badge-custom pull-right">예약중</span></s:if></p> 
      </div>
    </div>
  </div>
  		</s:iterator>
</div>

	<s:if test="list.size() <= 0">
		등록된 게시물이 없습니다.
	</s:if>
<s:property value="pagingHtml" escape="false" />

<jsp:include page="/footer.jsp"/>