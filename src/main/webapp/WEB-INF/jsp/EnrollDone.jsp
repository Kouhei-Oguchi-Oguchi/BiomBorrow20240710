<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="model.MedicalEquipmentResult"%>
 <%@ page import="model.MedicalEquipment"%>
 <% 
 String Message = (String)request.getAttribute("Message");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BiomBorrow</title>
</head>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<body>
<h1>機器登録完了</h1>
<p>${Message}</p>
<ul>
				<li><a href="WelcomeBiomBorrowServlet">BiomBorrow</a>
				<li><a href="BorrowStartServlet">Borrow</a></li>
				<li><a href="ReturnStartServlet">Return</a></li>
			</ul>
</body>
</html>