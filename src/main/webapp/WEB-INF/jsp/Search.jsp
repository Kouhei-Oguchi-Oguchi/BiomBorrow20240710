<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BiomBorrow</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Registration.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css">
<script src="${pageContext.request.contextPath}/js/menu.js" defer></script>
</head>
<body>
    <header>
	<h1>機器情報</h1>
	</header>
	<h1>Search</h1>
	<form action='SearchServlet' method='post'>
		<lavel for='medicalEquipment'>4桁番号</lavel>
		<input type='text' name='medicalEquipment' pattern='[1-9][0-9]{3}'>
		<input type='hidden' name='formType' value='medicalEquipmentForm'>
		<button type='submit'>送信</button>
	</form>
	<h1>習得</h1>
	<form action = 'SearchServlet' method='post'>
	<label for = 'itemName'>機器選択</label> <select id = 'itemName' name = 'itemName'>
	<option value ='Infusion Pump' >輸液ポンプ</option>
	</select>
	<input type ='hidden' name ='formType' value = 'itemNameForm'>
	<button type = 'submit'>送信</button>
	</form>
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