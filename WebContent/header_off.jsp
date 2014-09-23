<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <li><a href="login.jsp">로그인</a></li> -->
<li class="divider"></li>
<li><a href="#" class="btn-login" >로그인</a></li>
<li class="divider"></li>
<!-- 
<li><a href="login_ajax_form.jsp">로그인ajax</a></li> -->
<li><a href="signupForm.action">회원가입</a></li>

<%session.setAttribute("logined", false); %>