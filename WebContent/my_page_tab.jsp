<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<ul class="nav nav-tabs nav-justified" role="tablist" id="myTab">
  <li class="active"><a href="#selling" role="tab" data-toggle="tab">팔기</a></li>
  <li><a href="#buying" role="tab" data-toggle="tab">사기</a></li>
  <li><a href="#favorites" role="tab" data-toggle="tab">찜</a></li>
  <li><a href="#settings" role="tab" data-toggle="tab">나의 정보</a></li>
</ul>

<div class="tab-content">
  <div class="tab-pane active" id="selling"><jsp:include page="/now_selling.jsp"/></div>
  <div class="tab-pane" id="buying"><jsp:include page="/now_buying.jsp"/></div>
  <div class="tab-pane" id="favorites"><jsp:include page="/my_favorite.jsp"/></div>
  <div class="tab-pane" id="settings"><jsp:include page="/my_info.jsp"/></div>
</div>

<script>
  $(function () {
    $('#myTab a:last').tab('show')
  })
</script>