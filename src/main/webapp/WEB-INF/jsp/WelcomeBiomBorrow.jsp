<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BiomBorrow</title>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/css/style.css">
<script src="js/script.js" defer></script>

</head>
<body>
	<h1>BiomBorrow</h1>
	<div class="container">
    <div class="item borrow-item">
        <li><a href="BorrowStartServlet">Borrow</a></li>
    </div>
    <div class="item return-item">
        <li><a href="ReturnStartServlet">Return</a></li>
    </div>
    <div class="item search-item">
        <li><a href="SearchStartServlet">Search</a></li>
    </div>
    <div class="item enroll-item">
        <li><a href="EnrollStartServlet">Enroll</a></li>
    </div>
    <button id ="btn">ダークモード</button>
</div>
	
</body>
</html>