<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/header.jsp"/><br>

<form id="productForm" action="productCreate.action" class="form-horizontal" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label class="col-lg-3 control-label">*상품명</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="title_p" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-3 control-label">*가격</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="price"/>
        </div>
    </div>
    
	 <div class="form-group">
        <label class="col-lg-3 control-label">*거래방법</label>
        <div class="col-lg-6">
            <input type="checkbox" name="type_direct" value="직거래"/>직거래
            <input type="checkbox" name="type_delivery" value="택배">택배
        </div>
    </div> 
    
    <div class="form-group">
        <label class="col-lg-3 control-label">직거래지역</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="area"/>
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-lg-3 control-label">*대표이미지</label>
        <div class="col-lg-6">
            <input type="file" name="mainupload" class="form-control form-control4" onkeydown="event.returnValue=false;">
        </div>
    </div> 
    
    <div class="form-group">
        <label class="col-lg-3 control-label">추가이미지</label>
        <div class="col-lg-6">
            <input type="file" name="uploads" class="form-control form-control4" onkeydown="event.returnValue=false;">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-lg-3 control-label">추가이미지</label>
        <div class="col-lg-6">
            <input type="file" name="uploads"  class="form-control form-control4" onkeydown="event.returnValue=false;">
        </div>
    </div>  
    
    <div class="form-group">
        <label class="col-lg-3 control-label">추가이미지</label>
        <div class="col-lg-6">
            <input type="file" name="uploads"  class="form-control form-control4" onkeydown="event.returnValue=false;">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-lg-3 control-label">추가이미지</label>
        <div class="col-lg-6">
            <input type="file" name="uploads"  class="form-control form-control4" onkeydown="event.returnValue=false;">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-lg-3 control-label">상품 설명</label>
        <div class="col-lg-6">
        <textarea rows="7" class="form-control" name="content_p"></textarea><br>
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-lg-3 control-label"></label>
        <div class="col-lg-6">
        <input type="submit" value="작성완료" class="btn btn-round-sm1">
        </div>
    </div>

</form>

<jsp:include page="/footer.jsp"/>