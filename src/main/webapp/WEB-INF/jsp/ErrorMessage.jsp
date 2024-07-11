<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.MedicalEquipmentResult"%>
<%@ page import="model.MedicalEquipment"%>

<%
String errorMessage = (String)request.getAttribute("errorMessage");

%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<meta charset="UTF-8">
<title>ErrorMessage</title>
<style>
body, html {
	height: 100%; /* コンテンツを中央に配置 */
	margin: 0; /* フォントスタイルを設定 */
}
.center-container{
 display: flex;
 justify-content: center;
 align-items: center;
 height: 100%;
}
.error-message {
	margin: 0 20px; /* 上下のマージンなし、左右は自動で中央揃え */
	padding: 20px;
	text-align: center;
	max-width: 600px; /* 最大幅を設定 */
	width: 100%;
	border: 1px solid #ff0000; /* 赤い枠線 */
	background-color: #ffecec; /* 薄い赤の背景色 */
	box-shadow: 0px 0px rgba(0,0,0,0.5) /* 影をつける */
}

ul {
	list-style: none; /* リストスタイルをなしに */
	padding: 0; /* パディングをゼロに */
}

li {
	display: inline; /* リスト項目をインラインで表示 */
	margin-right: 20px; /* 項目間のマージン */
}

a {
	text-decoration: none; /* リンクの下線を消す */
	color: #0000ff; /* リンクの色 */
}

a:hover {
	text-decoration: underline; /* ホバー時に下線を表示 */
}
</style>
</head>
<body>
	<div class="center-container">
		<div class="error-message">
			<h1>Error!</h1>
			<p>${errorMessage}</p>
			<ul>
				<li><a href="WelcomeBiomBorrowServlet">BiomBorrow</a>
				<li><a href="BorrowStartServlet">Borrow</a></li>
				<li><a href="ReturnStartServlet">Return</a></li>
			</ul>
		</div>
	</div>
</body>
</html>