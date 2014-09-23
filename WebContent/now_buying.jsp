<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h2 class="index-lg">구매 중</h2>     
<h>구매 가능한 상품은 
<s:if test="my_products==null">0 개 입니다.</s:if>
<s:else>
<b><s:property value="buyers_products"/></b>개 입니다.
</s:else>
</h><br>

<div class="row hidden-xs">
<s:iterator value="buyerlist" status="stat">
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
        
        <div class="action pull-right"> <!-- 목록에서 삭제 기능  -->
        <a id="buy-del" class="btn delete-button" href="#" data-nop="<s:property value="no_p"/>">
        
     <%--    data-nom="<s:property value="#session.no_m"/>" --%>
        <span class="glyphicon glyphicon-trash"></span></a>
    	</div>
        
        <h4><s:a href="%{viewURL}"><s:property value="title_p"/></s:a></h4>
        <p><s:property value="price"/>₩</p>
        <p>@<s:property value="seller_info"/><s:if test="status_p==1">예약중</s:if></p>

        <%-- 줄서기 표시부분 --%>
		<s:subset source="sellerString" start="#stat.index" count="1">
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
  
   
</div>
  
</s:iterator>  
  	
</div>

<div class="row hidden-sm hidden-md hidden-lg">
<s:iterator value="buyerlist" status="stat">
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
      <img src="<s:property value="main_image"/>" style="height: 200px; width: 100%; display: block;">
      </s:a>
    </div> 
      <div class="caption col-xs-6">
        
        <div class="action pull-right"> <!-- 목록에서 삭제 기능  -->
        <a id="buy-del" class="btn delete-button" href="#" data-nop="<s:property value="no_p"/>">
        
     <%--    data-nom="<s:property value="#session.no_m"/>" --%>
        <span class="glyphicon glyphicon-trash"></span></a>
    	</div>
        
        <h4><s:a href="%{viewURL}"><s:property value="title_p"/></s:a></h4>
        <p><s:property value="price"/>₩</p>
        <p>@<s:property value="seller_info"/><s:if test="status_p==1">예약중</s:if></p>

        <%-- 줄서기 표시부분 --%>
		<s:subset source="sellerString" start="#stat.index" count="1">
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
  
   
</div>
  
</s:iterator>  
  	
</div>

<script type="text/javascript">
document.getElementById("buy-del").onclick=function(){
  if(confirm('목록에서 제거하시겠습니까? 구매취소/줄서기 취소가 됩니다.')){
	 location.href= "#" /* "deleteLine.action"; */
  }else{
	 alert('목록에서 제거를 취소했습니다.');
  }
};	 
</script>

<s:property value="pagingHtml" escape="false" />
        