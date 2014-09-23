<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<jsp:include page="/header.jsp"/><br>

<form id="signupForm" action="memberCreate.action" class="form-horizontal" method="post" enctype="multipart/form-data">

	<div class="form-group">
        <label class="col-lg-3 control-label"></label>
        <div class="col-lg-6">
        	<h4>필수 입력 정보</h4>
        </div>
    </div>

	<div class="form-group">
        <label class="col-lg-3 control-label">*이름</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="name" />
        </div>
    </div>

	<div class="form-group">
        <label class="col-lg-3 control-label">*이메일</label>
        <div class="col-lg-6">
            <input type="email" class="form-control" name="email" />
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-lg-3 control-label">*휴대폰 번호</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="phone" />
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-lg-3 control-label">*비밀 번호</label>
        <div class="col-lg-6">
            <input type="password" class="form-control" name="password" />
        </div>
    </div>    
    <div class="form-group">
        <label class="col-lg-3 control-label">*비밀 번호 체크</label>
        <div class="col-lg-6">
            <input type="password" class="form-control" name="password_check" />
        </div>
    </div>        
    
   	<div class="form-group">
        <label class="col-lg-3 control-label"></label>
        <div class="col-lg-6">
        	<h4>선택 입력</h4>
        </div>
    </div>
    
        <div class="form-group">
        <label class="col-lg-3 control-label">닉네임</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="nickname" />
        </div>
    </div> 
    
    <div class="form-group">
        <label class="col-lg-3 control-label">우편번호</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="zipcode" />
        </div>
    </div> 
    
        <div class="form-group">
        <label class="col-lg-3 control-label">주소</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="address1" />
        </div>
    </div> 
    
        <div class="form-group">
        <label class="col-lg-3 control-label">상세주소</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="address2" />
        </div>
    </div> 
    
        <div class="form-group">
        <label class="col-lg-3 control-label">은행</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="bank_name" />
        </div>
    </div> 
    
        <div class="form-group">
        <label class="col-lg-3 control-label">계좌 번호</label>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="bank_account" />
        </div>
    </div> 
    
        <div class="form-group">
        <label class="col-lg-3 control-label">프로필 이미지</label>
        <div class="col-lg-6">
            <input type="file" name="uploads" onkeydown="event.returnValue=false;"><br>
        </div>
    </div> 
    
    <div class="form-group">
        <label class="col-lg-3 control-label"></label>
        <div class="col-lg-6">
<!--         <input type="reset" value="다시입력" class="btn btn-default"> 이게 있으면 null일 경우 validation에 추가해야 하는데 귀찮음..-->
        <input type="submit" value="회원가입" class="btn btn-round-sm1">
        </div>
    </div>
    

</form>

<jsp:include page="/footer.jsp"/>