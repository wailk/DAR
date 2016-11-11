<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion Pagee</title>
</head>
<body>
	Page de connexion
	<form name="frm" method="post" action="Login">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="22%">&nbsp;</td>
				<td width="78%">&nbsp;</td>
			</tr>
			<tr>
				<td>Login</td>
				<td><input type="text" name="login"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>

</body>
</html>