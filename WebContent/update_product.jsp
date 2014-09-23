<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<jsp:include page="/header.jsp"/><br>

<form id="productForm" action="updateProduct.action" class="form-horizontal" method="post" enctype="multipart/form-data">
<input type="hidden" name="no_p" value="${no_p }">
    <div class="form-group">
        <label class="col-lg-3 control-label">*상품명</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="title_p" 
            value="<s:property value="productVO.title_p"/>" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-3 control-label">*가격</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="price"
            value="<s:property value="productVO.price"/>" />
        </div>
    </div>
    
	 <div class="form-group">
        <label class="col-lg-3 control-label">*거래방법</label>
        <div class="col-lg-6">
        
            <input type="checkbox" name="type_direct" value="직거래"/>직거래
            <input type="checkbox" name="type_delivery" value="택배">택배

        <s:if test="productVO.type_delivery==null&&productVO.type_direct==null">
 			  선택하신 거래방법이 없습니다. 선택해주세요</s:if>
    	     <s:property value ="productVO.type_delivery"/>
  		<s:if test="productVO.type_delivery!=null&&productVO.type_direct!=null">
   		, </s:if>
   			<s:property value="productVO.type_direct"/>
            
        </div>
    </div> 
    
    <div class="form-group">
        <label class="col-lg-3 control-label">직거래지역</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="area"
            value="<s:property value="productVO.area"/>" />
        </div>
    </div>

<!-- 추가     -->
       

    <div class="form-group"> 
        <label class="col-lg-3 control-label">대표이미지</label>
        <div class="col-lg-6">
        	<s:if test='p_ImageVO.main_image!=null'>
    			<img src="<s:property value="p_ImageVO.main_image"/>" class="modify-img img-rounded"/><br>
    		</s:if>
            <input type="file" name="mainupload2" class="form-control form-control4" onkeydown="event.returnValue=false;">
        </div>
    </div>  

 
    <div class="form-group">
        <label class="col-lg-3 control-label">추가이미지</label>
        <div class="col-lg-6">
        
       	 	<s:if test='p_ImageVO.image2!=null'>
    			<img src="<s:property value="p_ImageVO.image2"/>" class="modify-img img-rounded"/><br>
    		</s:if>
            <input type="file" name="uploads2" class="form-control form-control4" onkeydown="event.returnValue=false;">
            <!-- <input type="button" value="파일삭제" onClick="delFile()"> -->
        </div>
    </div>
    

    <div class="form-group">
        <label class="col-lg-3 control-label">추가이미지</label>
        <div class="col-lg-6">
        	<s:if test='p_ImageVO.image3!=null'>
    			<img src="<s:property value="p_ImageVO.image3"/>" class="modify-img img-rounded"/><br>
    		</s:if>
            <input type="file" name="uploads3" class="form-control form-control4" onkeydown="event.returnValue=false;">
        </div>
    </div>  
    
 
    <div class="form-group">
        <label class="col-lg-3 control-label">추가이미지</label>
        <div class="col-lg-6">
        	<s:if test='p_ImageVO.image4!=null'>
    			<img src="<s:property value="p_ImageVO.image4"/>" class="modify-img img-rounded"/><br>
    		</s:if>
            <input type="file" name="uploads4" class="form-control form-control4" onkeydown="event.returnValue=false;">
        </div>
    </div>

    

    <div class="form-group">
        <label class="col-lg-3 control-label">추가이미지</label>
        <div class="col-lg-6">
        	<s:if test='p_ImageVO.image5!=null'>
    			<img src="<s:property value="p_ImageVO.image5"/>" class="modify-img img-rounded"/><br>
    		</s:if>
            <input type="file" name="uploads5" class="form-control  form-control4" onkeydown="event.returnValue=false;">
        </div>
    </div>
    
 
    <div class="form-group">
        <label class="col-lg-3 control-label">상품 설명</label>
        <div class="col-lg-6">
        <textarea rows="7" class="form-control" name="content_p"><s:property value="productVO.content_p"/>
        </textarea>
        </div>
    </div>

    <div class="form-group">
        <label class="col-lg-3 control-label"></label>
        <div class="col-lg-6">
        <input type="submit" value="수정하기" class="btn btn-round-sm1">
        </div>
    </div>

</form>


<jsp:include page="/footer.jsp"/>