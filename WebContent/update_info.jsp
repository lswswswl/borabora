<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="/header.jsp" /><br>


<!-- <div class="container"> -->
<div class="row">
	<div class="col-md-5  toppad  pull-right col-md-offset-3 "></div>
	<!--         <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >-->
	<div
		class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-0 toppad">

		<div class="panel myinfo-custom">
			<div class="panel-heading">
				<h3 class="panel-title">
					<b><s:property value="memberVO.email" /></b>
				</h3>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-3 col-lg-3 " align="center">
						<s:if test='memberVO.profile_image!=null'>
							<img src="<s:property value="memberVO.profile_image" />"
								class="img-circle" style="width: 150px; height: 150px;">
						</s:if>
						<s:else>
							<img
								src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100"
								class="img-circle" style="width: 150px; height: 150px;">
						</s:else>

					</div>

					<div class=" col-md-9 col-lg-9 ">
						<form action="myInfoUpdate.action" method="post" enctype="multipart/form-data">
							<table class="table table-user-information">
								<tbody>
									<tr>
										<td>닉네임</td>
										<div class="input-group"><td><input type="text" name="nickname" class="form-control form-control2"
											value="<s:property value="memberVO.nickname"/>"></td></div>
									</tr>
									<tr>
										<td>휴대폰 번호</td>
										<div class="input-group"><td><input type="text" name="phone" class="form-control form-control2"
											value="<s:property value="memberVO.phone"/>"></td></div>
									</tr>
									<tr>
										<td>주소</td>
										<div class="input-group"><td><input type="text" name="address1" class="form-control form-control2"
											value="<s:property value="memberVO.address1"/>"></td></div>
									</tr>
									<tr>
										<td>상세주소</td>
										<div class="input-group"><td><input type="text" name="address2" class="form-control form-control2"
											value="<s:property value="memberVO.address2"/>"></td></div>
									</tr>
									<tr>
										<td>우편번호</td>
										<div class="input-group"><td><input type="text" name="zipcode" class="form-control form-control2"
											value="<s:property value="memberVO.zipcode"/>"></td></div>
									</tr>
									<tr>
										<td>은행이름</td>
										<div class="input-group"><td><input type="text" name="bank_name" class="form-control form-control2"
											value="<s:property value="memberVO.bank_name"/>"></td></div>
									</tr>
									<tr>
										<td>계좌번호</td>
										<div class="input-group"><td><input type="text" name="bank_account" class="form-control form-control2"
											value="<s:property value="memberVO.bank_account"/>"></td></div>
									</tr>
									<tr>
										<td>프로필 이미지</td>
										<td><input type="file" name="uploads" onkeydown="event.returnValue=false;"></td>
									</tr>
									<tr>
										<td></td>
										<td><input type="submit" class="btn btn-round-sm1" value="변경하기"></td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- </div> -->

<jsp:include page="/footer.jsp" />