<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>p_comment.jsp</title>
</head>
<body>

	<div class="row">
        <div class="comment-custom side-margin">
          <form action="commentCreate.action" method="post" role="form">
          <input type="hidden" name="currentPage" value="${currentPage}">
          <input type="hidden" name="no_p" value="${no_p}">
          <fieldset>
    
            <!-- Message body -->
            <div class="form-group">
            
    		<h4 for="message">Comment</h4>
            <textarea class="form-control" id="message" name="content_c" placeholder="댓글을 입력하세요..." rows="5"></textarea>
            
            </div>
    
            <!-- Form actions -->
            <div class="form-group text-right">
            <s:if test="#session.no_m == null">
            	<a href="#" class="btn-login btn btn-round-sm1">등록 </a>
            </s:if>
            <s:else>
               <button type="submit" class="btn btn-round-sm1">등록</button>
            </s:else>
            </div>
          </fieldset>
          </form>
        </div>

    </div>  

    <div class="row">
        <div class="comment-board-custom widget side-margin">
            <div class="panel-heading">
                <span class="glyphicon glyphicon-comment"></span>
                <h3 class="panel-title">
                    Recent Comments</h3>
    			<span class="label label-info"><s:property value="totalComment"/>
                    </span>
            </div>
            <div class="panel-body">
                <ul class="list-group">
                    <s:iterator value="commentList" status="stat">
                    <li class="list-group-item comment<s:property value="re_level"/>">
                        <div class="row">
                            <div class="col-xs-2 col-md-2 comment-thumb">
                                <s:if test='profile_image!=null'>
									<img src="<s:property value="profile_image" />"
									class="img-circle img-responsive">
								</s:if>
								<s:else>
									<img src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100"
									class="img-circle img-responsive">
								</s:else></div>
                            <div class="col-xs-10 col-md-10">
                                <div class="pull-right">
                                    <div class="mic-info">
                                       	  <s:property value="reg_date_c" />
                                    </div>
                                </div>
                                	<b>@<s:property value="commentor_info"/> </b>
                                <div class="comment-text">
                                <s:if test='replyto == null'>
                                <s:property value="content_c" />
                                </s:if><s:else>TO.@<s:property value="replyto"/> : <s:property value="content_c" /></s:else>
                                </div>
                                <div class="action pull-right">
                                    <a class="btn update-button" data-toggle="collapse" data-target="#comment_<s:property value="no_c"/>">
                                        <span class="glyphicon glyphicon-pencil" ></span>
                                    </a>
                                    <a class="btn-del btn delete-button" href="#" data-nop="<s:property value="no_p"/>" data-noc="<s:property value="no_c"/>">
                                        <span class="glyphicon glyphicon-trash"></span>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="comment-custom collapse"  id="comment_<s:property value="no_c"/>">
				          <form action="commentCreate2.action" method="post" role="form">
				          <input type="hidden" name="no_p" value="<s:property value="no_p"/>">
						  <input type="hidden" name="no_c" value="<s:property value="no_c"/>">
						  <input type="hidden" name="currentPage" value="${currentPage}">
						  
				          <fieldset>
				    
				            <!-- Message body -->
				            <div class="form-group">
				            
				    		<label for="message">Comment</label>
				            <textarea class="form-control" id="message" name="content_c" placeholder="댓글을 입력하세요..." rows="5"></textarea>
				            
				            </div>
				    
				            <!-- Form actions -->
				            <div class="form-group text-right">
				            	<s:if test="#session.no_m == null">
            					<a href="#" class="btn-login btn btn-round-sm1">등록 </a>
           						</s:if>
            					<s:else>
               					<button type="submit" class="btn btn-round-sm1">등록</button>
            					</s:else>
				            </div>
				          </fieldset>
				          </form>
				        </div>
                    </li>
                    </s:iterator>
                </ul> 
            </div>
            <div class="panel-footer2">
            </div>
            
        </div>
    </div>
<!-- Button trigger modal -->
<!-- 
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" data-noc="2" data-nop="6">
  Launch demo modal
</button>
<a href ="#" class="btn-del btn btn-primary btn-lg" data-noc="2" data-nop="6">test</a>
 -->
<!-- Modal -->
<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <form class="form-horizontal" action="commentDelete.action" method="post">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">삭제 확인</h4>
      </div>
      <div class="modal-body">
			<input id="noc" type="hidden" name="no_c" value="">
			<input id="nop" type="hidden" name="no_p" value="">
			<div class="form-group">
			    <label for="pw" class="col-sm-2 control-label">비밀번호</label>
			    <div class="col-sm-10">
			      <input type="password" id="pw" class="form-control" name="password" placeholder="비밀번호를 입력해 주세요.">
			    </div>
			  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">취소하기</button>
        <button type="submit" class="btn btn-primary">삭제하기</button>
      </div>
      </form>
    </div>
  </div>
</div>

</body>
</html>