<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Start</title>
</head>
<body>
<form action="Welcome.jsp" method="post">
	<input type="submit" value="Welcome">
</form>

<form action="guess" method="post">
	${message}
	<input type="text" name="guess_number">
	<input type="submit" value="guess">
</form>
</body>
</html>