<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BiomBorrow</title>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Registration.css">
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/css/menu.css">
<script src="${pageContext.request.contextPath}/js/menu.js" defer></script>
</head>
<body>
	<h1>Borrow</h1>
	<form action='BorrowServlet' method='post'>
		<label for='Borrow-time'>貸出日</label> <input type='datetime-local'
			id='Borrow-time' name='Borrow-time'> <label
			for='medicalEquiment'>4桁番号</label> <input type='text'
			name='medicalEquiment' pattern='[1-9][0-9]{3}'> <label
			for='department'>部署</label> <select id='department' name='department'>
			<option value='1'>本館3階東</option>
			<option value='2'>本館3階西</option>
			<option value='3'>本館2階西</option>
			<option value='4'>介護医療院</option>
			<option value='5'>南館4階病棟</option>
			<option value='6'>南館3階病棟</option>
			<option value='7'>南館2階病棟</option>
			<option value='8'>南館1階病棟</option>
			<option value='9'>南新館</option>
			<option value='10'>リハビリ</option>
		</select> <input type='submit' value='貸出登録'>
	</form>
	<%
	String errorMessage = (String) request.getAttribute("errorMessage");
	%>
	<%
	if (errorMessage != null && !errorMessage.isEmpty()) {
	%>
	<p style="color: red;"><%=errorMessage%></p>
	<%
	}
	%>
	<nav>
		<button id="menu-open" class="btn-menu">
			<svg height="24" viewBox="0 0 24 24" width="24"
				xmlns="http://www.w3.org/2000/svg">
            <path clip-rule="evenodd"
					d="m4.25 8c0-.41421.33579-.75.75-.75h14c.4142 0 .75.33579.75.75s-.3358.75-.75.75h-14c-.41421 0-.75-.33579-.75-.75zm0 4c0-.4142.33579-.75.75-.75h14c.4142 0 .75.3358.75.75s-.3358.75-.75.75h-14c-.41421 0-.75-.3358-.75-.75zm.75 3.25c-.41421 0-.75.3358-.75.75s.33579.75.75.75h14c.4142 0 .75-.3358.75-.75s-.3358-.75-.75-.75z"
					fill-rule="evenodd" />
        </svg>
		</button>
		<div id="menu-panel">
			<button id="menu-close" class="btn-menu">
				<svg height="24" viewBox="0 0 24 24" width="24"
					xmlns="http://www.w3.org/2000/svg">
                <path clip-rule="evenodd"
						d="m7.53033 6.46967c-.29289-.29289-.76777-.29289-1.06066 0s-.29289.76777 0 1.06066l4.46963 4.46967-4.46963 4.4697c-.29289.2929-.29289.7677 0 1.0606s.76777.2929 1.06066 0l4.46967-4.4696 4.4697 4.4696c.2929.2929.7677.2929 1.0606 0s.2929-.7677 0-1.0606l-4.4696-4.4697 4.4696-4.46967c.2929-.29289.2929-.76777 0-1.06066s-.7677-.29289-1.0606 0l-4.4697 4.46963z"
						fill-rule="evenodd" />
            </svg>
			</button>
			<ul class="menu-list">
				<li><a href="WelcomeBiomBorrowServlet">BiomBorrow</a></li>
				<li><a href="BorrowStartServlet">Borrow</a></li>
				<li><a href="ReturnStartServlet">Return</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>