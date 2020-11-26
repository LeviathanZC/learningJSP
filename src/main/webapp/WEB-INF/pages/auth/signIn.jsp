<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<html lang="ru">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="../../../css/reset.css">
	<link rel="stylesheet" href="../../../css/common.css">
	<link rel="stylesheet" href="../../../css/input.css">
	<link rel="stylesheet" href="../../../css/login.css">
	<title>Вход | Интернет-магазин</title>
</head>
<body>
	<div class="container">
		<main>
		<h1 class="main__login">ВОЙТИ</h1>
		<form method="POST" action="http://localhost:8888/servlet" class="main__signIn" id="signIn">
			<div class="signIn__row">
				<p>ЛОГИН</p>
				<input class="data" required type="text" name="login" form="signIn">
			</div>
			<div class="error">${requestScope.error}</div>
			<div class="signIn__row">
				<p>ПАРОЛЬ</p>
				<input class="data" required type="password" name="password" form="signIn">
			</div>
			<div class="signIn__hrefs">
				<a href="#">Забыли пароль?</a>
				<a href="#">Регистрация</a>
			</div>
			<input type="submit" name="submit" value="ВХОД" form="signIn" class="btn">
		</form>
	</main>
	</div>
</body>
</html>