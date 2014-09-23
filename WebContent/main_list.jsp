<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h3>Best</h3>
<div class="row">
<s:iterator value="blist" status="stat">
<s:url id="viewURL" action="productRead">
<s:param name="no_p">
	<s:property value="no_p" />
</s:param>
<s:param name="currentPage">
	<s:property value="currentPage"/>
</s:param>
</s:url>
  <div class="hidden-xs col-sm-4 col-md-4">
    <div class="thumbnail">
      <s:a href="%{viewURL}">
      <img src="<s:property value="main_image"/>" style="height: 200px; width: 100%; display: block;">
      </s:a>
      <div class="caption">
        <h4><s:a href="%{viewURL}"><s:property value="title_p"/></s:a></h4>
        <p><s:property value="price"/>₩</p>
        <p>@<s:property value="seller_info"/><s:if test="status_p==1"><span class="badge-custom pull-right">예약중</span></s:if></p>
      </div>
    </div>
  </div>
</s:iterator>
<s:iterator value="blist2" status="stat">
<s:url id="viewURL" action="productRead">
<s:param name="no_p">
	<s:property value="no_p" />
</s:param>
<s:param name="currentPage">
	<s:property value="currentPage"/>
</s:param>
</s:url>
  <div class="col-xs-6 hidden-sm hidden-md hidden-lg">
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

<h3>New</h3>
<div class="row">
<s:iterator value="nlist" status="stat">
<s:url id="viewURL" action="productRead">
<s:param name="no_p">
	<s:property value="no_p" />
</s:param>
<s:param name="currentPage">
	<s:property value="currentPage"/>
</s:param>
</s:url>
  <div class="hidden-xs col-sm-4 col-md-4">
    <div class="thumbnail">
      <s:a href="%{viewURL}">
      <img src="<s:property value="main_image"/>" style="height: 200px; width: 100%; display: block;">
      </s:a>
      <div class="caption">
        <h4><s:a href="%{viewURL}"><s:property value="title_p"/></s:a></h4>
        <p><s:property value="price"/>₩</p>
        <p>@<s:property value="seller_info"/><s:if test="status_p==1"><span class="badge-custom pull-right">예약중</span></s:if></p>
      </div>
    </div>
  </div>
</s:iterator>
<s:iterator value="nlist2" status="stat">
<s:url id="viewURL" action="productRead">
<s:param name="no_p">
	<s:property value="no_p" />
</s:param>
<s:param name="currentPage">
	<s:property value="currentPage"/>
</s:param>
</s:url>
  <div class="col-xs-6 hidden-sm hidden-md hidden-lg">
    <div class="thumbnail">
      <s:a href="%{viewURL}">
      <img src="<s:property value="main_image"/>" style="height: 200px; width: 100%; display: block;">
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