<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 

<!-- 프로토 타입 로그인, 현재 모달로 대체해 쓰이지 않음, 참고용 -->
 
<jsp:include page="/header.jsp"/>
 
<form id="loginForm" class="form-horizontal"  action="loginJson.action" method="post" role="form">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input name="email" type="email" class="form-control" id="inputEmail3" placeholder="Email">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input name="password" type="password" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success">로그인</button>
      <a href="signupForm.action" class="btn btn-default">회원가입</a>
    </div>
  </div>
</form>


<jsp:include page="/footer.jsp"/>