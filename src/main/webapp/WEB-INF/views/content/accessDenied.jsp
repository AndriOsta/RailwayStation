<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/resources/css/home.css"
	rel="stylesheet" />
<title>Access denied!</title>
</head>
<body>
		<h1 style="color: red;">ACCESS is DENIED!</h1>
	<h2 style="color: red;">${errorMsg}</h2>
</body>
</html>