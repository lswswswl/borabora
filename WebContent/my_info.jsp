<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  

<!-- <div class="container"> -->
	<div class="row">
 		<div class="col-md-5  toppad  pull-right col-md-offset-3 "></div>
		<!--         <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >-->
		<div
			class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-0 toppad">

			<div class="panel myinfo-custom">
				<div class="panel-heading">
					<h3 class="panel-title"><b><s:property value="memberVO.email"/></b></h3>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-3 col-lg-3 " align="center">
						<s:if test='memberVO.profile_image!=null'>
							<img src="<s:property value="memberVO.profile_image" />" 
								class="img-circle" style="width: 150px; height: 150px;">
						</s:if>	
						<s:else>
							<img src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100"
								class="img-circle" style="width: 150px; height: 150px;">
						</s:else>	
						</div>

						<div class=" col-md-9 col-lg-9 ">
							<table class="table table-user-information">
								<tbody>
									<tr>
										<td>닉네임</td>
										<td>
										<s:if test="memberVO.nickname==null">닉네임을 설정해주세요.</s:if>
										<s:else>@<s:property value="memberVO.nickname"/></s:else></td>
									</tr>
									<tr>
										<td>휴대폰 번호</td>
										<td><s:property value="memberVO.phone"/></td>
									</tr>
									<tr>
										<td>주소</td>
										<td>
										<s:if test="memberVO.address1==null">주소를 설정해주세요.</s:if>
										<s:else>
										<s:property value="memberVO.address1"/><br><s:property value="memberVO.address2"/></td>
										</s:else>
									</tr>
									<tr>
										<td>우편번호</td>
										<td>
										<s:if test="memberVO.zipcode==null">우편번호를 설정해주세요.</s:if>
										<s:else>
										<s:property value="memberVO.zipcode"/></td>
										</s:else>
									</tr>
									<tr>
										<td>계좌정보</td>
										<td>
										<s:if test="memberVO.bank_name==null">계좌정보를 설정해주세요.</s:if>
										<s:else><s:property value="memberVO.bank_name"/> <s:property value="memberVO.bank_account"/></s:else>
										</td>
									</tr>
							
									<tr>
										<td>예치금</td>
										<td><s:property value="memberVO.balance"/> 원</td>
									</tr>
									<tr>
										<td>등록상품</td>
										<td><s:property value="memberVO.registered_product"/> 개</td>
									</tr>
									<tr>
										<td>판매 횟수</td>
										<td><s:property value="memberVO.sold"/> 번</td>
									</tr>
									<tr>
										<td>구매 횟수</td>
										<td><s:property value="memberVO.bought"/> 번</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<span class="pull-right">
						<a href="myInfoUpdateForm.action" data-original-title="Edit this user"
						data-toggle="tooltip" type="button" class="btn update-button"><i
							class="glyphicon glyphicon-pencil"></i></a> 
						<a id="del" href="#" data-original-title="Remove this user" data-toggle="tooltip"
						type="button" class="btn delete-button"><i
							class="glyphicon glyphicon-trash"></i></a>
					</span>
				</div>
			</div>
		</div>
	</div>
<!-- </div> -->


<script type="text/javascript">
document.getElementById("del").onclick=function(){
  if(confirm('계정을 삭제하시겠습니까?')){
	 location.href= "myInfoDelete.action";
  }else{
	 alert('계정삭제를 취소했습니다.');
  }
};	 
</script>

