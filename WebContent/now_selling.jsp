<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h2 class="index-lg">판매 중</h2>     
<h>나의 판매중 상품은 
<s:if test="my_products==null">0 개 입니다.</s:if>
<s:else>
<b><s:property value="my_products"/></b>개 입니다.
</s:else>
</h><br>

<div class="row hidden-xs">
<s:iterator value="list" status="stat">
<s:url id="viewURL" action="productRead">
<s:param name="no_p">
	<s:property value="no_p" />
</s:param>
<s:param name="currentPage">
	<s:property value="currentPage"/>
</s:param>
</s:url>
<div class="row thumbnail mypage-list">
  <div class="col-sm-4 col-md-4 mypage-thumb">
	<s:a href="%{viewURL}">
      <img src="<s:property value="main_image"/>">
      </s:a>
    
  </div>
  
  <div class="caption col-sm-8 col-md-8">
  <div class="action pull-right"> <!-- 상품 수정 삭제 기능 추가 후 action연결 -->
    	
    <form action="updateProductForm.action" method="post" class="write-button-custom" >
  		<input type="hidden" name="no_p" value="${no_p }">
  		<button type="submit" class="btn write-button2"><span class="glyphicon glyphicon-pencil" ></span></button>
 	</form> 
 		
 	<%--  	
    	<a class="btn update-button" href="#">
        <span class="glyphicon glyphicon-pencil" ></span></a> --%>
        <a class="btn-delPro btn delete-button" href="#" data-nop="<s:property value="no_p"/>">
        <span class="glyphicon glyphicon-trash"></span></a> 
    
    </div>
  
    <h4><s:a href="%{viewURL}"><s:property value="title_p"/></s:a></h4>
    
    <p><s:property value="price"/>₩</p>
  
  
  </div>
  
  <%-- 줄서기 표시부분 --%>
		<s:subset source="buyersString" start="#stat.index" count="1">
			<s:iterator>
    
<%-- pre태그 내부에서는 들여쓰기 불가.
	무엇이든 입력한 그대로 화면에 내보냄 --%>	       		
<pre class="line-list">
<s:property/>
</pre>
<%-- pre태그 내부에서는 들여쓰기 불가.
	무엇이든 입력한 그대로 화면에 내보냄 --%>
			</s:iterator>
	    </s:subset>
        </p>
        <%-- 줄서기 표시부분 --%>
  
  
  
  
</div> 
</s:iterator>
</div>

<div class="row hidden-sm hidden-md hidden-lg">
<s:iterator value="list" status="stat">
<s:url id="viewURL" action="productRead">
<s:param name="no_p">
	<s:property value="no_p" />
</s:param>
<s:param name="currentPage">
	<s:property value="currentPage"/>
</s:param>
</s:url>
<div class="row thumbnail mypage-list">
  <div class="col-xs-6 mypage-thumb">
	<s:a href="%{viewURL}">
      <img src="<s:property value="main_image"/>">
      </s:a>
    
  </div>
  
  <div class="caption col-xs-6">
  <div class="action pull-right"> <!-- 상품 수정 삭제 기능 추가 후 action연결 -->
    	
    <form action="updateProductForm.action" method="post" class="write-button-custom" >
  		<input type="hidden" name="no_p" value="${no_p }">
  		<button type="submit" class="btn write-button2"><span class="glyphicon glyphicon-pencil" ></span></button>
 	</form> 
 		
 	<%--  	
    	<a class="btn update-button" href="#">
        <span class="glyphicon glyphicon-pencil" ></span></a> --%>
        <a class="btn-delPro btn delete-button" href="#" data-nop="<s:property value="no_p"/>">
        <span class="glyphicon glyphicon-trash"></span></a> 
    
    </div>
  
    <h4><s:a href="%{viewURL}"><s:property value="title_p"/></s:a></h4>
    
    <p><s:property value="price"/>₩</p>
  
  
  </div>
  
  <%-- 줄서기 표시부분 --%>
		<s:subset source="buyersString" start="#stat.index" count="1">
			<s:iterator>
    
<%-- pre태그 내부에서는 들여쓰기 불가.
	무엇이든 입력한 그대로 화면에 내보냄 --%>	       		
<pre class="line-list">
<s:property/>
</pre>
<%-- pre태그 내부에서는 들여쓰기 불가.
	무엇이든 입력한 그대로 화면에 내보냄 --%>
			</s:iterator>
	    </s:subset>
        </p>
        <%-- 줄서기 표시부분 --%>
  
  
  
  
</div> 
</s:iterator>
</div>

<!-- Modal 추가 -->
<%-- <form action="deleteProductForm.action" method="post" style="padding-top: 30px;">
   <input type="hidden" name="no_p" value="${no_p }">
   <input type="submit" value="삭제" class="btn btn-default btn-round-lg btn-lg">
  </form> 
--%>
<div class="modal fade" id="delProModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <form class="form-horizontal" action="deleteProduct.action" method="post">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">삭제 확인</h4>
      </div>
      <div class="modal-body">
   <input id="nop" type="hidden" name="no_p" value="">
   <div class="form-group">
       <label for="pw" class="col-sm-2 control-label">비밀번호</label>
       <div class="col-sm-10">
         <input type="password" id="pw" class="form-control" name="password" placeholder="비밀번호를 입력해 주세요.">
       </div>
   </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-round-sm2" data-dismiss="modal">취소하기</button>
        <button type="submit" class="btn btn-round-sm1">삭제하기</button>
      </div>
      </form>
    </div>
  </div>
</div>

<s:property value="pagingHtml" escape="false" />