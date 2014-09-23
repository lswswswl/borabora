<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>review.jsp</title>
</head>
<body>

<form action="reviewCreate.action" method="POST" enctype="multipart/form-data">
<input type="hidden" name="no_p" value="${no_p }"/>
<h3>후기 작성</h3>
제목 : <input type="text" name="title_r"><br>
내용<br>
<textarea name="content_r" cols="50" rows="5"></textarea><br>
이미지 : <input type="file" name="reviews"/><br>
<br><input type="submit" value="후기 작성">
</form>

</body>
</html>