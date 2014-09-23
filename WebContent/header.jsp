<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String headerResult="/header_off.jsp";
if (session.getAttribute("no_m")!=null){
	headerResult="/header_on.jsp"; 
}

String headerResult_sm="/header_off.jsp";
if (session.getAttribute("no_m")!=null){
	headerResult_sm="/header_on_sm.jsp"; 
}
%>
<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>BoraBora</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/bootstrapValidator.min.css"/>
        <link rel="stylesheet" href="css/main.css">

        <!--[if lt IE 9]>
            <script src="js/vendor/html5-3.6-respond-1.1.0.min.js"></script>
        <![endif]-->
    </head>
    <body>

 
    <div class="container">
    
<div class="header hidden-xs">
  <ul class="nav nav-pills pull-right header-menu-custom">
    <li><a href="categoryList.action">전체 상품보기</a></li>
    <jsp:include page="<%=headerResult%>"/> 
  </ul>
<!--   <h3 class="active"><b><a href="index.jsp" style="text-decoration:none">BoraBora</a></b></h3> -->
<a href="index.jsp"><img src="img/borabora3.png" class="logo-borabora image-responsive"/></a>
</div>   

<div class="header navbar-header hidden-sm hidden-md hidden-lg">
<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
<a href="index.jsp"><img src="img/borabora3.png" class="logo-borabora image-responsive"/></a>

<div class="navbar-collapse collapse text-right">
          <ul class="nav navbar-nav">
            <li class="active"><a href="categoryList.action">전체 상품보기</a></li>
            <jsp:include page="<%=headerResult_sm%>"/>

          </ul>
        </div>

</div> 



