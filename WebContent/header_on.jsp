<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<li class="dropdown">
 <a href="#" class="dropdown-toggle" data-toggle="dropdown">
 	안뇽  <b><%=session.getAttribute("nickname") %></b> 님 ! 
 	<span class="caret"></span>
</a>
  <ul class="dropdown-menu" role="menu">
    <li><a href="myInfoRead.action">마이페이지</a></li>
    <li class="divider"></li>
    <li><a href="logout.action">로그아웃</a></li>
  </ul>
</li>