<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    {
      "login": <%= session.getAttribute("logined")%>,
      "msg" : "난 back에서 온 메시지요"
    }